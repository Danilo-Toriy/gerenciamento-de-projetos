package com.example.danilo.controller;

import com.example.danilo.entity.Projeto;
import com.example.danilo.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto novoProjeto){
        Projeto projeto = projetoService.save(novoProjeto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll(){
        List<Projeto> projetoList = projetoService.findAll();
        return projetoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(projetoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id){
        Optional<Projeto> projetoAchado = projetoService.findById(id);
        return projetoAchado.isPresent()
                ? ResponseEntity.ok().body(projetoAchado.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @RequestBody Projeto projetoAtualizado){
        Projeto projeto = projetoService.update(id, projetoAtualizado);
        return ResponseEntity.ok(projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        projetoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
