package com.senai.gestao_escolar.dto.turma;

public record TurmaResponse(
        long id,
        String nome,
        Long curso_id,
        Long professor_id
) {
}
