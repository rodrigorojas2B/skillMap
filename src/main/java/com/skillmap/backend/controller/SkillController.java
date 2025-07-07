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
