package com.champis.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "t_usuario")
@NamedQueries({
        @NamedQuery(name="User.findUser",
                query = "SELECT u FROM TUsuario u WHERE u.username = :username AND u.password = :password"
        ),
        @NamedQuery(name="User.updatePassword" ,
                query = "UPDATE TUsuario SET password = :password WHERE id = :id"
        )
})
public class TUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public TUsuario() {
    }

    public TUsuario(String username, String password, String correo) {
        this.username = username;
        this.password = password;
        this.correo = correo;
    }

    @Column(name = "username", length = 80)
    private String username;

    @Column(name = "password", length = 80)
    private String password;

    @Column(name = "correo", length = 80)
    private String correo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}