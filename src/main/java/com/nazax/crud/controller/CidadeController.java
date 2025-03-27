package com.nazax.crud.controller;

import com.nazax.crud.dtos.CidadeDTO;
import com.nazax.crud.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    // 🔍 Buscar todas as cidades
    @GetMapping
    public ResponseEntity<List<CidadeDTO>> findAll() {
        List<CidadeDTO> cidades = cidadeService.findAll();
        return ResponseEntity.ok(cidades); // Retorna HTTP 200 OK
    }

    // 🔍 Buscar cidade por ID
    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathVariable Long id) {
        CidadeDTO cidade = cidadeService.findById(id);
        return (cidade != null) ? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
    }

    // 🔍 Buscar cidades pelo nome
    @GetMapping("/buscar")
    public ResponseEntity<List<CidadeDTO>> findByNome(@RequestParam String nome) {
        List<CidadeDTO> cidades = cidadeService.findByNome(nome);
        return (cidades.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(cidades);
    }

    // ➕ Criar ou atualizar uma cidade
    @PostMapping
    public ResponseEntity<CidadeDTO> save(@RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidadeSalva = cidadeService.save(cidadeDTO);
        return ResponseEntity.status(201).body(cidadeSalva); // Retorna HTTP 201 Created
    }

    // ❌ Deletar cidade pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cidadeService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content
    }
}