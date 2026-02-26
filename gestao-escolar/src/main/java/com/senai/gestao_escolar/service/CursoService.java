package com.senai.gestao_escolar.service;

import com.senai.gestao_escolar.dto.curso.CursoRequest;
import com.senai.gestao_escolar.dto.curso.CursoResponse;
import com.senai.gestao_escolar.mapper.CursoMapper;
import com.senai.gestao_escolar.model.Curso;
import com.senai.gestao_escolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoService(CursoRepository repository, CursoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CursoResponse save(CursoRequest request) throws SQLException {
        Curso curso = new Curso(request.nome(), request.codigo());
        repository.save(curso);
        return mapper.toResponse(curso);
    }

    public List<CursoResponse> list () throws SQLException {
        List<Curso> cursos = repository.list();

        return cursos.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CursoResponse findById(long id) throws SQLException {
        Curso curso = repository.findById(id);
        return mapper.toResponse(curso);
    }

    public CursoResponse update(long id, CursoRequest request) throws SQLException {
        Curso cursoBanco = repository.findById(id);

        //Valida os campos do body e altera apenas os camppos que não são nulos ou vazios
        cursoBanco.update(request.nome(), request.codigo());

        Curso cursoEditado = repository.update(cursoBanco);

        return mapper.toResponse(cursoEditado);
    }

    public void delete(long id) throws SQLException {
        repository.delete(id);
    }
}
