package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skill_map")
@Getter
@Setter
@NoArgsConstructor
public class SkillMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;

    @Column(length = 20)
    private String grado;

    @Column(nullable = false)
    private Integer nivel_base;
}
