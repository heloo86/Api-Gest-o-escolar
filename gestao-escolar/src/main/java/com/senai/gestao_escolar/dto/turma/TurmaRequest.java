package com.senai.gestao_escolar.dto.turma;

public record TurmaRequest(
        String nome,
        Long curso_id,
        Long professor_id
) {
}
