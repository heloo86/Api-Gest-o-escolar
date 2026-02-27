package com.senai.gestao_escolar.service;

import com.senai.gestao_escolar.dto.turma.TurmaRequest;
import com.senai.gestao_escolar.dto.turma.TurmaResponse;
import com.senai.gestao_escolar.dto.turma.TurmaRequest;
import com.senai.gestao_escolar.dto.turma.TurmaResponse;
import com.senai.gestao_escolar.mapper.TurmaMapper;
import com.senai.gestao_escolar.model.Turma;
import com.senai.gestao_escolar.model.Turma;
import com.senai.gestao_escolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;
    private final TurmaMapper mapper;

    public TurmaService(TurmaRepository repository, TurmaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TurmaResponse save (TurmaRequest request) throws SQLException {
        Turma turma = mapper.toEntity(request);
        repository.save(turma);
        return mapper.toResponse(turma);
    }
    
    public List<TurmaResponse> list () throws SQLException {
        List<Turma> turmaes = repository.list();

        return turmaes.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public TurmaResponse findById(long id) throws SQLException {
        Turma turma = repository.findById(id);
        return mapper.toResponse(turma);
    }

    public TurmaResponse update(long id, TurmaRequest request) throws SQLException {
        Turma turmaBanco = repository.findById(id);

        //Valida os campos do body e altera apenas os camppos que não são nulos ou vazios
        turmaBanco.update(request.nome(), request.professor_id(),request.curso_id());

        Turma turmaEditado = repository.update(turmaBanco);

        return mapper.toResponse(turmaEditado);
    }

    public void delete(long id) throws SQLException {
        repository.delete(id);
    }
}
