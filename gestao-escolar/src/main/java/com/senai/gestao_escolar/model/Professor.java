package com.senai.gestao_escolar.model;

public class Professor {

    private long id;
    private String nome;
    private String email;
    private String disciplina;

    public Professor(long id, String nome, String email, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.disciplina = disciplina;
    }

    public Professor(String nome, String email, String disciplina) {
        this.nome = nome;
        this.email = email;
        this.disciplina = disciplina;
    }

    public Professor() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void update(String nome, String email, String disciplina){

        if (!nome.isBlank()){
            this.nome = nome;
        }

        if (!email.isBlank()){
            this.email = email;
        }

        if (!disciplina.isBlank()){
            this.disciplina = disciplina;
        }
    }
}
