package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombre;
    @ManyToOne
    @NotNull
    private Categoria categoria;
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
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
package com.skillmap.backend.repository;
import com.skillmap.backend.model.Skill;
import org.springframework.data.repository.CrudRepository;
public interface SkillRepository extends CrudRepository<Skill, Long> {
}
package com.skillmap.backend.service;
import com.skillmap.backend.model.Skill;
import com.skillmap.backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SkillService {
    private final SkillRepository skillRepository;
    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }
    public Iterable<Skill> getAll() {
        return skillRepository.findAll();
    }
    public Skill getById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}
package com.skillmap.backend.controller;
import com.skillmap.backend.model.Skill;
import com.skillmap.backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;
    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.save(skill);
    }
    @GetMapping
    public Iterable<Skill> getAllSkills() {
        return skillService.getAll();
    }
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getById(id);
    }
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        Skill existingSkill = skillService.getById(id);
        if (existingSkill != null) {
            existingSkill.setNombre(skill.getNombre());
            existingSkill.setCategoria(skill.getCategoria());
            return skillService.save(existingSkill);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.delete(id);
    }
}
