package com.example.livraria.mapper;

import com.example.livraria.dto.LivroRequestDTO;
import com.example.livraria.dto.LivroResponseDTO;
import com.example.livraria.entity.Livro;

public class LivroMapper {

    public static Livro toEntity(LivroRequestDTO dto) {
        return Livro.builder()
                .nome(dto.nome())
                .paginas(dto.paginas())
                .autor(dto.autor())
                .categoria(dto.categoria())
                .build();
    }

    public static void updateEntity(Livro entity, LivroRequestDTO dto) {
        entity.setNome(dto.nome());
        entity.setPaginas(dto.paginas());
        entity.setAutor(dto.autor());
        entity.setCategoria(dto.categoria());
    }

    public static LivroResponseDTO toResponse(Livro entity) {
        return new LivroResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getPaginas(),
                entity.getAutor(),
                entity.getCategoria()
        );
    }
}
