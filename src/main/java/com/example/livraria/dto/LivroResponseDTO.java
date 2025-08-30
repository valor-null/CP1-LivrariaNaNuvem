package com.example.livraria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados do livro")
public record LivroResponseDTO(
        @Schema(example = "1") Long id,
        @Schema(example = "Clean Code") String nome,
        @Schema(example = "464") Integer paginas,
        @Schema(example = "Robert C. Martin") String autor,
        @Schema(example = "Tecnico") String categoria
) {}
