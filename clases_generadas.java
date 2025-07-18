package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String paterno;
    private String materno;
    
    @OneToOne
    private Colaborador calibrador;
}
package com.skillmap.backend.repository;
import com.skillmap.backend.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
package com.skillmap.backend.service;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    public Colaborador createColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
    public List<Colaborador> getAllColaboradores() {
        return colaboradorRepository.findAll();
    }
    public Optional<Colaborador> getColaboradorById(Long id) {
        return colaboradorRepository.findById(id);
    }
    public Colaborador updateColaborador(Long id, Colaborador colaboradorDetails) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findById(id);
        if (!optionalColaborador.isPresent()) {
            return null;
        }
        colaboradorDetails.setId(id);
        return colaboradorRepository.save(colaboradorDetails);
    }
    public void deleteColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
package com.skillmap.backend.controller;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;
    @PostMapping
    public ResponseEntity<Colaborador> createColaborador(@RequestBody Colaborador colaborador) {
        return ResponseEntity.ok(colaboradorService.createColaborador(colaborador));
    }
    @GetMapping
    public ResponseEntity<List<Colaborador>> getAllColaboradores() {
        return ResponseEntity.ok(colaboradorService.getAllColaboradores());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> getColaboradorById(@PathVariable Long id) {
        return ResponseEntity.of(colaboradorService.getColaboradorById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaboradorDetails) {
        Colaborador colaborador = colaboradorService.updateColaborador(id, colaboradorDetails);
        if (colaborador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(colaborador);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
        return ResponseEntity.ok().build();
    }
}
