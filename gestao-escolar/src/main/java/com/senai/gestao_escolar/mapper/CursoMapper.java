package com.senai.gestao_escolar.mapper;

import com.senai.gestao_escolar.dto.curso.CursoRequest;
import com.senai.gestao_escolar.dto.curso.CursoResponse;
import com.senai.gestao_escolar.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoResponse toResponse(Curso entity){
        return new CursoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getCodigo()
        );
    }

    public Curso toEntity(CursoRequest request){
        return new Curso(
                request.nome(),
                request.codigo()
        );
    }
}
