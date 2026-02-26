package com.senai.gestao_escolar.controller;

import com.senai.gestao_escolar.dto.professor.ProfessorRequest;
import com.senai.gestao_escolar.dto.professor.ProfessorResponse;
import com.senai.gestao_escolar.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestao_escolar/professor")
public class ProfessorController {


    private ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @PostMapping
    public ProfessorResponse save (@RequestBody ProfessorRequest request){
        try {
            return service.save(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<ProfessorResponse> list (){
        try{
            return service.list();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ProfessorResponse findById(@PathVariable Long id){
        try {
            return service.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ProfessorResponse update(@PathVariable long id,
                                @RequestBody ProfessorRequest request){
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
