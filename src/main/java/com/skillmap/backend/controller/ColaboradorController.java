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
