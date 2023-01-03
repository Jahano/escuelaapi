package com.champis.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_calificaciones")
public class TCalificacione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones", nullable = false)
    private Integer id;

    @Column(name = "id_t_usuarios", nullable = false)
    private Integer idTUsuarios;

    @Column(name = "calificacion", precision = 10, scale = 2)
    private BigDecimal calificacion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}