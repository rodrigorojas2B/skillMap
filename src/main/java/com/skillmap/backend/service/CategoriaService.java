package com.skillmap.backend.service;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.repository.CategoriaRepository;
import com.skillmap.backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private SkillRepository skillRepository;
    public Categoria crearCategoria(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre.");
        }
        return categoriaRepository.save(categoria);
    }
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre.");
        }
        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La categoría no existe."));
        categoriaExistente.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaExistente);
    }
    public void eliminarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La categoría no existe."));
        if (skillRepository.existsByCategoria(categoria)) {
            throw new IllegalArgumentException("La categoría está asignada a una o más habilidades.");
        }
        categoriaRepository.delete(categoria);
    }
}
