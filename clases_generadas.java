package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Entity
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(1)
    @Max(5)
    private Integer nivel;
    @NotNull
    @Column(length = 500)
    private String url_curso;
    @NotNull
    @Column(length = 500)
    private String url_test;
    @NotNull
    private Long skill_id;
    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNivel() {
        return nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public String getUrl_curso() {
        return url_curso;
    }
    public void setUrl_curso(String url_curso) {
        this.url_curso = url_curso;
    }
    public String getUrl_test() {
        return url_test;
    }
    public void setUrl_test(String url_test) {
        this.url_test = url_test;
    }
    public Long getSkill_id() {
        return skill_id;
    }
    public void setSkill_id(Long skill_id) {
        this.skill_id = skill_id;
    }
}
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
