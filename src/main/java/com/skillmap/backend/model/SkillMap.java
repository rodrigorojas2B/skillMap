package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "skill_map")
public class SkillMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grado")
    private String grado;

    @Column(name = "nivel_base")
    private int nivelBase;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
}
