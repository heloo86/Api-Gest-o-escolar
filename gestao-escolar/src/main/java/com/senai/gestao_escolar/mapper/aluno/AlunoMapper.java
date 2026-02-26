package com.senai.gestao_escolar.mapper.aluno;

import com.senai.gestao_escolar.dto.aluno.AlunoRequest;
import com.senai.gestao_escolar.dto.aluno.AlunoResponse;
import com.senai.gestao_escolar.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public AlunoResponse toResponse(Aluno entity) {
        return new AlunoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getMatricula(),
                entity.getData_nascimento()
        );
    }

    public Aluno toEntity(AlunoRequest request) {
        return new Aluno(
                request.nome(),
                request.email(),
                request.matricula(),
                request.data_nascimento()
        );
    }
}
