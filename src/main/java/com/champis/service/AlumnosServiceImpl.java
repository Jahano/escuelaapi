package com.champis.service;

import com.champis.data.AlumnosDao;
import com.champis.domain.TAlumno;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class AlumnosServiceImpl implements AlumnosService{
    @Inject
    AlumnosDao alumnosDao;

    @Override
    public List<TAlumno> getAllAlumnos() {
        return alumnosDao.selectAllAlumno();
    }
}
