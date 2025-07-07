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
