package com.escuela.service;

import com.escuela.domain.TAlumno;
import com.escuela.domain.TCalificacion;
import com.escuela.domain.TMateria;
import jakarta.ejb.Local;
import org.json.JSONArray;

import java.util.List;
@Local
public interface EscuelaService {

    public List<TAlumno> getAllAlumnos();

    public String setCalificacion(TCalificacion calificacion);

    public String addCalificion(TCalificacion calificacion);

    public String eliminarCalificacion(TCalificacion calificacion);

    public JSONArray consultarCalificaciones(int idAlumno);

    public List<TMateria> getAllMaterias();

}
