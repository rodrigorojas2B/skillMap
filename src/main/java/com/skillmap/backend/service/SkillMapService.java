package com.skillmap.backend.service;
import com.skillmap.backend.model.SkillMap;
import com.skillmap.backend.repository.SkillMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SkillMapService {
    private final SkillMapRepository skillMapRepository;
    @Autowired
    public SkillMapService(SkillMapRepository skillMapRepository) {
        this.skillMapRepository = skillMapRepository;
    }
    public SkillMap saveSkillMap(SkillMap skillMap) {
        return skillMapRepository.save(skillMap);
    }
}
