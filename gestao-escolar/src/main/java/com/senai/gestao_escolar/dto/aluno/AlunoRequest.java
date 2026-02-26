package com.senai.gestao_escolar.dto.aluno;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        String email,
        String matricula,
        LocalDate data_nascimento
) {
}
