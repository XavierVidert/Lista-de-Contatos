package com.primeira.appSpring.entity;

public class Contato {

    private Long id;
    private String nome;
    private String apelido;
    private String email;
    private String telefone;

    // Construtores, Getters e Setters

    public Contato(Long id, String nome, String apelido, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
