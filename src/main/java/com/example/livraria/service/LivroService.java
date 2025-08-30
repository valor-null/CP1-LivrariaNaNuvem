package com.example.livraria.service;

import com.example.livraria.dto.LivroRequestDTO;
import com.example.livraria.dto.LivroResponseDTO;
import com.example.livraria.entity.Livro;
import com.example.livraria.exception.LivroNotFoundException;
import com.example.livraria.mapper.LivroMapper;
import com.example.livraria.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository repository;

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> listar() {
        return repository.findAll().stream().map(LivroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public LivroResponseDTO buscarPorId(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));
        return LivroMapper.toResponse(livro);
    }

    @Transactional
    public LivroResponseDTO criar(LivroRequestDTO dto) {
        Livro salvo = repository.save(LivroMapper.toEntity(dto));
        return LivroMapper.toResponse(salvo);
    }

    @Transactional
    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));
        LivroMapper.updateEntity(livro, dto);
        return LivroMapper.toResponse(repository.save(livro));
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) throw new LivroNotFoundException(id);
        repository.deleteById(id);
    }
}
