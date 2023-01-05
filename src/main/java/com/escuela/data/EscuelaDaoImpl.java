package com.escuela.data;


import com.escuela.domain.CalificacionesCustom;
import com.escuela.domain.TAlumno;
import com.escuela.domain.TCalificacion;
import com.escuela.domain.TMateria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


@Stateless
public class EscuelaDaoImpl implements EscuelaDao{

    final String SELECT_CALIFICACIONES = "SELECT c.id_t_usuarios, a.nombre,a.ap_paterno as apellido , m.nombre as materia, m.id_t_materias, c.calificacion ,date_format(c.fecha_registro, '%d-%m-%Y') as fecha_registro from t_calificaciones c \n" +
            " INNER JOIN t_materias m on c.id_t_materias = m.id_t_materias \n" +
            " INNER JOIN t_alumnos a on c.id_t_usuarios = a.id_t_usuarios\n" +
            " WHERE c.id_t_usuarios = ?;";

    @PersistenceContext(unitName = "EscuelaPU")
    EntityManager em;


    @Override
    public List<TAlumno> selectAllAlumno() {
        Query query = em.createNamedQuery("Alumnos.findAll");
        return query.getResultList();
    }

    @Override
    public String updateCalificacion(TCalificacion calificacion) {

        JSONObject response = new JSONObject();

        try {
            Query query = em.createNamedQuery("TCalificaciones.getCalificacion");
            query.setParameter("idMateria" , calificacion.getIdTMaterias());
            query.setParameter("idAlumno" , calificacion.getIdTUsuarios());
            BigDecimal nuevaCalificacion = calificacion.getCalificacion();
            calificacion = (TCalificacion)query.getSingleResult();
            calificacion.setCalificacion(nuevaCalificacion);
            em.merge(calificacion);
            response.put("success","ok");
            response.put("msg","Calificacion actualizada");
        }catch (Exception ex){
            response.put("success","false");
            response.put("msg",ex.getMessage());

        }
        return response.toString();
    }

    @Override
    public String insertCalificacion(TCalificacion calificacion) {
        JSONObject response = new JSONObject();
        try {
            em.persist(calificacion);
            response.put("success","ok");
            response.put("msg","Calificacion Registrada");
        }catch (Exception ex){
            response.put("success","false");
            response.put("msg",ex.getMessage());

        }


        return response.toString();
    }

    @Override
    public String deleteCalificacion(TCalificacion calificacion) {
        JSONObject response = new JSONObject();
        try {
            Query query = em.createNamedQuery("TCalificacion.deleteCalificacion");
            query.setParameter("idAlumno", calificacion.getIdTUsuarios());
            query.setParameter("idMateria", calificacion.getIdTMaterias());
            query.executeUpdate();

            response.put("success","ok");
            response.put("msg","Calificacion Eliminada");
        }catch (Exception ex){
            response.put("success","false");
            response.put("msg",ex.getMessage());

        }
        return response.toString();
    }

    @Override
    public JSONArray selectCalificacionesAlumno(int idAlumno) {


        //OBTENIENDO PROMEDIO
        Query query = em.createNamedQuery("TCalificacion.getPromedio");
        query.setParameter("idAlumno", idAlumno);
        BigDecimal promedio =(BigDecimal) query.getSingleResult();
        JSONObject promedioJson = new JSONObject();
        promedioJson.put("promedio",promedio.setScale(2, RoundingMode.HALF_UP));

        //OBTENIENDO CALIFICACIONES X MATERIA
        query = em.createNativeQuery(SELECT_CALIFICACIONES);
        query.setParameter(1,idAlumno);
        JSONArray response = new JSONArray( query.getResultList());
        response = formatResponse(response);
        response.put(promedioJson);
        return  response;
    }

    @Override
    public List<TMateria> selectAllMaterias() {
        Query query = em.createNamedQuery("TMaterias.selectAllMaterias");
        return query.getResultList();
    }

    public JSONArray formatResponse(JSONArray jsonArray){
        ArrayList<CalificacionesCustom> aList = new ArrayList();
        List l = jsonArray.toList();
        for (Object list:l) {
            List lista = (List)list;
            System.out.println(lista.toString());
            CalificacionesCustom c = new CalificacionesCustom();
            c.setId_t_usuarios((int)lista.get(0));
            c.setNombre((String)lista.get(1));
            c.setApellido((String)lista.get(2));
            c.setMateria((String)lista.get(3));
            c.setId_t_materia((int)lista.get(4));
            c.setCalificacion(new BigDecimal(lista.get(5).toString()));
            c.setFechaRegistro((String)lista.get(6));

            aList.add(c);

            //new SimpleDateFormat("dd/MM/yyyy").parse(sDate1)
        }


        return new JSONArray(aList);
    }

}
