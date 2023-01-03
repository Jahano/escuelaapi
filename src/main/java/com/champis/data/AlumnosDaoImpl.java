package com.champis.data;


import com.champis.domain.TAlumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class AlumnosDaoImpl implements AlumnosDao {

    @PersistenceContext(unitName = "EscuelaPU")
    EntityManager em;


    @Override
    public List<TAlumno> selectAllAlumno() {
        Query query = em.createNamedQuery("Alumnos.findAll");
        return query.getResultList();
    }
}
