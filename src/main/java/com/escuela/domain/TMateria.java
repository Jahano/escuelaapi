package com.escuela.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "t_materias")
@NamedQueries({
        @NamedQuery(name="TMaterias.selectAllMaterias", query="SELECT m FROM TMateria m")
})
public class TMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_materias", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "activo")
    private Integer activo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

}