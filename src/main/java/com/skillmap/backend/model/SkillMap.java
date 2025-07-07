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
