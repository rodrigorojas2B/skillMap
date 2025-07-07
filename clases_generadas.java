package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String paterno;
    private String materno;
    
    @OneToOne
    private Colaborador calibrador;
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
    public String getPaterno() {
        return paterno;
    }
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    public Colaborador getCalibrador() {
        return calibrador;
    }
    public void setCalibrador(Colaborador calibrador) {
        this.calibrador = calibrador;
    }
}
package com.skillmap.backend.repository;
import org.springframework.data.repository.CrudRepository;
import com.skillmap.backend.model.Colaborador;
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {
}
package com.skillmap.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.repository.ColaboradorRepository;
@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;
    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }
    public Colaborador save(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
    public Iterable<Colaborador> getAll() {
        return colaboradorRepository.findAll();
    }
    public Colaborador getById(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
package com.skillmap.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.service.ColaboradorService;
@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;
    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }
    @PostMapping
    public ResponseEntity<Colaborador> create(@RequestBody Colaborador colaborador) {
        return new ResponseEntity<>(colaboradorService.save(colaborador), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Colaborador>> getAll() {
        return new ResponseEntity<>(colaboradorService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> getById(@PathVariable Long id) {
        return new ResponseEntity<>(colaboradorService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        colaboradorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
