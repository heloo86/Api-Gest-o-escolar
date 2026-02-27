package com.senai.gestao_escolar.model;

import java.util.List;

public class Turma {

    private long id;
    private String nome;
    private Long curso_id;
    private Long professor_id;

    public Turma(long id, String nome, long curso_id, Long professor_id) {
        this.id = id;
        this.nome = nome;
        this.curso_id = curso_id;
        this.professor_id = professor_id;
    }

    public Turma(String nome, long curso_id, Long professor_id) {
        this.nome = nome;
        this.curso_id = curso_id;
        this.professor_id = professor_id;
    }

    public Turma() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(long curso_id) {
        this.curso_id = curso_id;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public void update(String nome, Long curso_id, Long professor_id){

        if(!nome.isBlank()){
            this.nome = nome;
        }

        if(curso_id != null){
            this.curso_id = curso_id;
        }

        if(professor_id != null){
            this.professor_id = professor_id;
        }

    }
}
