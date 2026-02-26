package com.senai.gestao_escolar.controller;

import com.senai.gestao_escolar.dto.curso.CursoRequest;
import com.senai.gestao_escolar.dto.curso.CursoResponse;
import com.senai.gestao_escolar.dto.curso.CursoRequest;
import com.senai.gestao_escolar.dto.curso.CursoResponse;
import com.senai.gestao_escolar.service.CursoService;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestao_escolar/curso")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public CursoResponse save(@RequestBody CursoRequest request){
        try {
            return service.save(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<CursoResponse> list (){
        try{
            return service.list();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public CursoResponse findById(@PathVariable Long id){
        try {
            return service.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public CursoResponse update(@PathVariable long id,
                                    @RequestBody CursoRequest request){
        try {
            return service.update(id, request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable long id){
        try {
            service.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
