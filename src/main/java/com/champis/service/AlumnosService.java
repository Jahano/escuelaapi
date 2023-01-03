package com.champis.service;

import com.champis.domain.TAlumno;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface AlumnosService {

    public List<TAlumno> getAllAlumnos();

}
