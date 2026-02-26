package com.senai.gestao_escolar.dto.aluno;

import java.time.LocalDate;

public record AlunoResponse(
        long id,
        String noeme,
        String email,
        String matricula,
        LocalDate data_nascimento
) {
}
