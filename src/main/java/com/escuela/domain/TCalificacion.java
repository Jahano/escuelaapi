package com.escuela.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_calificaciones")
@NamedQueries({
        @NamedQuery(name = "TCalificaciones.getCalificacion",
        query = "SELECT c from TCalificacion c WHERE c.idTMaterias = :idMateria and c.idTUsuarios = :idAlumno"),
        @NamedQuery(name="TCalificacion.getPromedio",
        query="SELECT (SUM(c.calificacion)/ (SELECT COUNT(c) FROM TCalificacion c WHERE c.idTUsuarios = :idAlumno ) ) FROM TCalificacion c  WHERE c.idTUsuarios = :idAlumno"),
        @NamedQuery(name="TCalificacion.deleteCalificacion",
                query="DELETE FROM TCalificacion c where c.idTUsuarios=:idAlumno AND c.idTMaterias=:idMateria")
        }


)
public class TCalificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones", nullable = false)
    private Integer id;

    @Column(name = "id_t_materias", nullable = false)
    private Integer idTMaterias;

    @Column(name = "id_t_usuarios", nullable = false)
    private Integer idTUsuarios;

    @Column(name = "calificacion", precision = 10, scale = 2)
    private BigDecimal calificacion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    public TCalificacion() {
    }

    public TCalificacion(Integer idTMaterias, Integer idTUsuarios, BigDecimal calificacion) {
        this.idTMaterias = idTMaterias;
        this.idTUsuarios = idTUsuarios;
        this.calificacion = calificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTMaterias() {
        return idTMaterias;
    }

    public void setIdTMaterias(Integer idTMaterias) {
        this.idTMaterias = idTMaterias;
    }

    public Integer getIdTUsuarios() {
        return idTUsuarios;
    }

    public void setIdTUsuarios(Integer idTUsuarios) {
        this.idTUsuarios = idTUsuarios;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "TCalificacion{" +
                "id=" + id +
                ", idTMaterias=" + idTMaterias +
                ", idTUsuarios=" + idTUsuarios +
                ", calificacion=" + calificacion +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}