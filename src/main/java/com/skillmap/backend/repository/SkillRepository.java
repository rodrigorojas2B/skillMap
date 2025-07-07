package com.skillmap.backend.repository;
import com.skillmap.backend.model.Skill;
import org.springframework.data.repository.CrudRepository;
public interface SkillRepository extends CrudRepository<Skill, Long> {
}
