package com.senai.gestao_escolar.dto.professor;

public record ProfessorRequest(
        String nome,
        String email,
        String disciplina) {
}
