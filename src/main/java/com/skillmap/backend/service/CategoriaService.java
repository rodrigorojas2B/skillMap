// Clase NUEVA: CategoriaService
package com.skillmap.backend.service;

import com.skillmap.backend.dto.CategoriaDTO;
import com.skillmap.backend.mapper.CategoriaMapper;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriaDTO> getAll() {
        return categoriaRepository.findAll().stream()
            .map(categoria -> categoriaMapper.toDTO(categoria))
            .collect(Collectors.toList());
    }

    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria.setId(id);
        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
