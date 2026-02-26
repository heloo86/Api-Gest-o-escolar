package com.senai.gestao_escolar.service;

import com.senai.gestao_escolar.dto.professor.ProfessorRequest;
import com.senai.gestao_escolar.dto.professor.ProfessorResponse;
import com.senai.gestao_escolar.mapper.ProfessorMapper;
import com.senai.gestao_escolar.model.Professor;
import com.senai.gestao_escolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProfessorResponse save (ProfessorRequest request) throws SQLException {
        Professor professor = mapper.toEntity(request);
        repository.save(professor);
        return mapper.toResponse(professor);
    }

    public List<ProfessorResponse> list () throws SQLException {
        List<Professor> professores = repository.list();

        return professores.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ProfessorResponse findById(long id) throws SQLException {
        Professor professor = repository.findById(id);
        return mapper.toResponse(professor);
    }

    public ProfessorResponse update(long id, ProfessorRequest request) throws SQLException {
        Professor professorBanco = repository.findById(id);

        //Valida os campos do body e altera apenas os camppos que não são nulos ou vazios
        professorBanco.update(request.nome(), request.email(),request.disciplina());

        Professor professorEditado = repository.update(professorBanco);

        return mapper.toResponse(professorEditado);
    }

    public void delete(long id) throws SQLException {
        repository.delete(id);
    }
}
