package com.primeira.appSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuario",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"usuario"}),
            @UniqueConstraint(columnNames = {"apelido"})
        })
public class M_Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String usuario;
    @Column(unique = true)
    private String apelido;
    private String senha;
    private String emael;

    public String getEmael() {
        return emael;
    }

    public void setEmael(String emael) {
        this.emael = emael;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
