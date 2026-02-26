package com.senai.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.senai.gestao_escolar.dto.professor.ProfessorRequest;
import com.senai.gestao_escolar.dto.professor.ProfessorResponse;
import com.senai.gestao_escolar.model.Professor;

@Component
public class ProfessorMapper {

        public ProfessorResponse toResponse(Professor entity) {
            return new ProfessorResponse(
                    entity.getId(),
                    entity.getNome(),
                    entity.getEmail(),
                    entity.getDisciplina()
            );
        }

        public Professor toEntity(ProfessorRequest request) {
            return new Professor(
                    request.nome(),
                    request.email(),
                    request.disciplina()
            );
        }
}
