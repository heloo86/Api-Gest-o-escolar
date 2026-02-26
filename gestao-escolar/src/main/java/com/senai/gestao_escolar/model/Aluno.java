package com.senai.gestao_escolar.model;

import java.time.LocalDate;

public class Aluno {
    //(nome, email, matricula, data_nascimento)
    private long Id;
    private String Nome;
    private String Email;
    private String Matricula;
    private LocalDate Data_nascimento;

    public Aluno(long id, String nome, String email, String matricula, LocalDate data_nascimento) {
        this.Id = id;
        this.Nome = nome;
        this.Email = email;
        this.Matricula = matricula;
        this.Data_nascimento = data_nascimento;
    }

    public Aluno() {
    }

    public Aluno(String nome, String email, String matricula, LocalDate data_nascimento) {
        Nome = nome;
        Email = email;
        Matricula = matricula;
        Data_nascimento = data_nascimento;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public LocalDate getData_nascimento() {
        return Data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.Data_nascimento = data_nascimento;
    }

    public void update(String nome, String email, String matricula, LocalDate data_nascimento) {

        if(!nome.isBlank()){
            this.Nome = nome;
        }

        if(!email.isBlank()){
            this.Email = email;
        }

        if(!matricula.isBlank()){
            this.Matricula = matricula;
        }

        if(data_nascimento != null){
            this.Data_nascimento = data_nascimento;
        }
    }
}
