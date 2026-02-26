package com.senai.gestao_escolar.controller;

import com.senai.gestao_escolar.dto.aluno.AlunoRequest;
import com.senai.gestao_escolar.dto.aluno.AlunoResponse;
import com.senai.gestao_escolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestao_escolar")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public AlunoResponse save (@RequestBody AlunoRequest request){
        try {
            return service.save(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<AlunoResponse> list (){
        try{
            return service.list();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public AlunoResponse findById(@PathVariable Long id){
        try {
            return service.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public AlunoResponse update(@PathVariable long id,
                                @RequestBody AlunoRequest request){
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
