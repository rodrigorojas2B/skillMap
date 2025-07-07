package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
package com.skillmap.backend.repository;
import com.skillmap.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNombre(String nombre);
}
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
package com.skillmap.backend.controller;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }
    @GetMapping
    public Iterable<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }
    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
package com.skillmap.backend.service;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
class CategoriaServiceTest {
    @InjectMocks
    private CategoriaService categoriaService;
    @Mock
    private CategoriaRepository categoriaRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createCategoria_nombreDuplicado_lanzaExcepcion() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Test");
        when(categoriaRepository.existsByNombre(categoria.getNombre())).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> categoriaService.createCategoria(categoria));
        verify(categoriaRepository, never()).save(any(Categoria.class));
    }
    @Test
    void updateCategoria_noExiste_lanzaExcepcion() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Test");
        when(categoriaRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> categoriaService.updateCategoria(1L, categoria));
        verify(categoriaRepository, never()).save(any(Categoria.class));
    }
    @Test
    void deleteCategoria_noExiste_lanzaExcepcion() {
        when(categoriaRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> categoriaService.deleteCategoria(1L));
        verify(categoriaRepository, never()).deleteById(anyLong());
    }
}
