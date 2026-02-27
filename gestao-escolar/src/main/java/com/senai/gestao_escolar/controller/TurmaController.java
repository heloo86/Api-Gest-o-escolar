package com.senai.gestao_escolar.controller;

import com.senai.gestao_escolar.dto.turma.TurmaRequest;
import com.senai.gestao_escolar.dto.turma.TurmaResponse;
import com.senai.gestao_escolar.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("getao_escola/turama")
public class TurmaController {

    private TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    public TurmaResponse save (@RequestBody TurmaRequest request){
        try {
            return service.save(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<TurmaResponse> list (){
        try{
            return service.list();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public TurmaResponse findById(@PathVariable Long id){
        try {
            return service.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public TurmaResponse update(@PathVariable long id,
                                    @RequestBody TurmaRequest request){
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
