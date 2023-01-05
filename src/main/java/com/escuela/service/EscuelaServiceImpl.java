package com.escuela.service;

import com.escuela.data.EscuelaDao;
import com.escuela.domain.TAlumno;
import com.escuela.domain.TCalificacion;
import com.escuela.domain.TMateria;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.json.JSONArray;

import java.util.List;

@Stateless
public class EscuelaServiceImpl implements EscuelaService  {
    @Inject
    EscuelaDao escuelaDao;

    @Override
    public List<TAlumno> getAllAlumnos() {
        return escuelaDao.selectAllAlumno();
    }

    @Override
    public String setCalificacion(TCalificacion calificacion) {
        return escuelaDao.updateCalificacion(calificacion);
    }

    @Override
    public String addCalificion(TCalificacion calificacion) {

        return escuelaDao.insertCalificacion(calificacion);
    }

    @Override
    public String eliminarCalificacion(TCalificacion calificacion) {
        return escuelaDao.deleteCalificacion(calificacion);
    }

    @Override
    public JSONArray consultarCalificaciones(int idAlumno) {
        return escuelaDao.selectCalificacionesAlumno(idAlumno);
    }

    @Override
    public List<TMateria> getAllMaterias() {
        return escuelaDao.selectAllMaterias();
    }
}
