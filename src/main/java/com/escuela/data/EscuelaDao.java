package com.escuela.data;

import com.escuela.domain.TAlumno;
import com.escuela.domain.TCalificacion;
import com.escuela.domain.TMateria;
import org.json.JSONArray;

import java.util.List;

public interface EscuelaDao {

    public List<TAlumno> selectAllAlumno();

    public String updateCalificacion(TCalificacion calificacion );

    public String insertCalificacion(TCalificacion calificacion);

    public String deleteCalificacion(TCalificacion calificacion);

    public JSONArray selectCalificacionesAlumno(int idAlumno);

    public List<TMateria> selectAllMaterias();
}
