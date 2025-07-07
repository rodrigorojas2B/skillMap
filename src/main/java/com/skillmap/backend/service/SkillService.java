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
