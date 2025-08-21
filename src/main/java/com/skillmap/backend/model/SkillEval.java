package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SkillEval {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nivelAutoeval;
    private int nivelCalibrado;
    private String observaciones;
    private double notaTest;
    private String urlEvidencia;

    @ManyToOne
    private SkillFit idSkillFit;

    @ManyToOne
    private Skill idSkill;
}
