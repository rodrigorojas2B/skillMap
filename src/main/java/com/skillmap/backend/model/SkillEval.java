package com.skillmap.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill_eval")
public class SkillEval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nivel_autoeval", nullable = false)
    private int nivelAutoeval;

    @Column(name = "nivel_calibrado", nullable = false)
    private int nivelCalibrado;

    @Column(length = 100)
    private String observaciones;

    @Column(name = "nota_test")
    private double notaTest;

    @Column(name = "url_evidencia")
    private String urlEvidencia;

    @ManyToOne
    @JoinColumn(name = "id_skill_fit")
    private SkillFit skillFit;

    @ManyToOne
    @JoinColumn(name = "id_skill")
    private Skill skill;
}
