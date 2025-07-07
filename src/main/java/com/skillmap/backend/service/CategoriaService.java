package com.skillmap.backend.service;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria createCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe");
        }
        return categoriaRepository.save(categoria);
    }
    public Iterable<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }
    public Categoria updateCategoria(Long id, Categoria categoria) {
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoría no existe");
        }
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe");
        }
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }
    public void deleteCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoría no existe");
        }
        categoriaRepository.deleteById(id);
    }
}
