package com.skillmap.backend.repository;
import com.skillmap.backend.model.SkillMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SkillMapRepository extends JpaRepository<SkillMap, Long> {
}
