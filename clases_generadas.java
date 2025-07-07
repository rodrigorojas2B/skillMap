package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "skill_map")
public class SkillMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "rol_id")
    private Long rolId;
    @NotNull
    @Column(name = "grado")
    private String grado;
    @NotNull
    @Column(name = "skill_id")
    private Long skillId;
    @NotNull
    @Min(1)
    @Max(5)
    @Column(name = "nivel_base")
    private Integer nivelBase;
    // getters and setters
}
package com.skillmap.backend.repository;
import com.skillmap.backend.model.SkillMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SkillMapRepository extends JpaRepository<SkillMap, Long> {
}
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
package com.skillmap.backend.controller;
import com.skillmap.backend.model.SkillMap;
import com.skillmap.backend.service.SkillMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/skillmap")
public class SkillMapController {
    private final SkillMapService skillMapService;
    @Autowired
    public SkillMapController(SkillMapService skillMapService) {
        this.skillMapService = skillMapService;
    }
    @PostMapping
    public ResponseEntity<SkillMap> createSkillMap(@RequestBody SkillMap skillMap) {
        return ResponseEntity.ok(skillMapService.saveSkillMap(skillMap));
    }
}
