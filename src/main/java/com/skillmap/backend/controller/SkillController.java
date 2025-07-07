package com.skillmap.backend.controller;
import com.skillmap.backend.model.Contenido;
import com.skillmap.backend.service.ContenidoService;
import com.skillmap.backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private ContenidoService contenidoService;
    // existing methods
    @PostMapping("/{id}/contenido")
    public Contenido createContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        contenido.setSkill_id(id);
        return contenidoService.save(contenido);
    }
    @GetMapping("/{id}/contenido/{contenidoId}")
    public Contenido getContenido(@PathVariable Long id, @PathVariable Long contenidoId) {
        Contenido contenido = contenidoService.get(contenidoId);
        if (contenido != null && contenido.getSkill_id().equals(id)) {
            return contenido;
        }
        return null;
    }
    @PutMapping("/{id}/contenido")
    public Contenido updateContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        if (contenido.getSkill_id().equals(id)) {
            return contenidoService.update(contenido);
        }
        return null;
    }
    @DeleteMapping("/{id}/contenido/{contenidoId}")
    public void deleteContenido(@PathVariable Long id, @PathVariable Long contenidoId) {
        Contenido contenido = contenidoService.get(contenidoId);
        if (contenido != null && contenido.getSkill_id().equals(id)) {
            contenidoService.delete(contenidoId);
        }
    }
}
