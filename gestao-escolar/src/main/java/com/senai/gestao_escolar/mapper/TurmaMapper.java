package com.senai.gestao_escolar.mapper;

import com.senai.gestao_escolar.dto.turma.TurmaRequest;
import com.senai.gestao_escolar.dto.turma.TurmaResponse;
import com.senai.gestao_escolar.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public TurmaResponse toResponse(Turma entity) {
        return new TurmaResponse(
                entity.getId(),
                entity.getNome(),
                entity.getProfessor_id(),
                entity.getCurso_id()
        );
    }

    public Turma toEntity(TurmaRequest request) {
        return new Turma(
                request.nome(),
                request.professor_id(),
                request.curso_id()
        );
    }
}
