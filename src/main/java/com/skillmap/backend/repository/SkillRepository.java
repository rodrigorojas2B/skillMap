package com.skillmap.backend.repository;
import com.skillmap.backend.model.Categoria;
import com.skillmap.backend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsByCategoria(Categoria categoria);
}
