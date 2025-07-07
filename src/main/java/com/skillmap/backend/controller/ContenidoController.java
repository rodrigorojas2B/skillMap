package com.skillmap.backend.controller;
import com.skillmap.backend.model.Contenido;
import com.skillmap.backend.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;
    @PostMapping
    public Contenido create(@RequestBody Contenido contenido) {
        return contenidoService.save(contenido);
    }
    @GetMapping("/{id}")
    public Contenido get(@PathVariable Long id) {
        return contenidoService.get(id);
    }
    @PutMapping
    public Contenido update(@RequestBody Contenido contenido) {
        return contenidoService.update(contenido);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contenidoService.delete(id);
    }
}
