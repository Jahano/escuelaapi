package com.escuela.domain;

import java.math.BigDecimal;

public class CalificacionesCustom {
    int id_t_usuarios;

    int id_t_materia;
    String nombre;
    String apellido;
    String materia;
    BigDecimal calificacion;
    String fechaRegistro;

    public CalificacionesCustom() {
    }

    public CalificacionesCustom(int id_t_usuarios, String nombre, String apellido, String materia, BigDecimal calificacion, String fechaRegistro) {
        this.id_t_usuarios = id_t_usuarios;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materia = materia;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId_t_usuarios() {
        return id_t_usuarios;
    }

    public void setId_t_usuarios(int id_t_usuarios) {
        this.id_t_usuarios = id_t_usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getId_t_materia() {
        return id_t_materia;
    }

    public void setId_t_materia(int id_t_materia) {
        this.id_t_materia = id_t_materia;
    }

    @Override
    public String toString() {
        return "CalificacionesCustom{" +
                "id_t_usuarios=" + id_t_usuarios +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", materia='" + materia + '\'' +
                ", calificacion=" + calificacion +
                ", fecha_registro=" + fechaRegistro +
                '}';
    }
}
