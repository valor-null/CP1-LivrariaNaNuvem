package com.example.livraria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados para criar/atualizar um livro")
public record LivroRequestDTO(
        @Schema(example = "Clean Code") @NotBlank String nome,
        @Schema(example = "464") @NotNull @Positive Integer paginas,
        @Schema(example = "Robert C. Martin") @NotBlank String autor,
        @Schema(example = "Tecnico") @NotBlank String categoria
) {}
