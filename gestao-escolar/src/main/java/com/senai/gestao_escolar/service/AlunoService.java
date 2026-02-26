package com.senai.gestao_escolar.service;

import com.senai.gestao_escolar.dto.aluno.AlunoRequest;
import com.senai.gestao_escolar.dto.aluno.AlunoResponse;
import com.senai.gestao_escolar.mapper.aluno.AlunoMapper;
import com.senai.gestao_escolar.model.Aluno;
import com.senai.gestao_escolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public AlunoService(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AlunoResponse save (AlunoRequest request) throws SQLException {
        Aluno aluno = mapper.toEntity(request);
        repository.save(aluno);
        return mapper.toResponse(aluno);
    }

    public List<AlunoResponse> list () throws SQLException {
        List<Aluno> alunos = repository.list();

        return alunos.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public AlunoResponse findById(long id) throws SQLException {
        Aluno aluno = repository.findById(id);
        return mapper.toResponse(aluno);
    }

    public AlunoResponse update(long id, AlunoRequest request) throws SQLException {
        Aluno alunoBanco = repository.findById(id);

        //Valida os campos do body e altera apenas os camppos que não são nulos ou vazios
        alunoBanco.update(request.nome(), request.email(),request.matricula(), request.data_nascimento());

        Aluno alunoEditado = repository.update(alunoBanco);

        return mapper.toResponse(alunoEditado);
    }

    public void delete(long id) throws SQLException {
        repository.delete(id);
    }
}
