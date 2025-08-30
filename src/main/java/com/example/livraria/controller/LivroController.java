package com.example.livraria.controller;

import com.example.livraria.dto.LivroRequestDTO;
import com.example.livraria.dto.LivroResponseDTO;
import com.example.livraria.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Livros", description = "Endpoints do CRUD de livros")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService service;

    @Operation(summary = "Lista todos os livros")
    @GetMapping
    public List<LivroResponseDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Busca um livro por ID")
    @GetMapping("/{id}")
    public LivroResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Cria um novo livro")
    @PostMapping
    public ResponseEntity<LivroResponseDTO> criar(@Valid @RequestBody LivroRequestDTO dto,
                                                  UriComponentsBuilder uriBuilder) {
        LivroResponseDTO criado = service.criar(dto);
        URI uri = uriBuilder.path("/api/livros/{id}").buildAndExpand(criado.id()).toUri();
        return ResponseEntity.created(uri).body(criado);
    }

    @Operation(summary = "Atualiza um livro por ID")
    @PutMapping("/{id}")
    public LivroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Remove um livro por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
