package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "skill_eval")
public class SkillEval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nivel_autoeval")
    private int nivelAutoeval;

    @Column(name = "nivel_calibrado")
    private int nivelCalibrado;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "nota_test")
    private BigDecimal notaTest;

    @Column(name = "url_evidencia")
    private String urlEvidencia;

    @ManyToOne
    @JoinColumn(name="id_skill_fit")
    private SkillFit skillFit;

    @ManyToOne
    @JoinColumn(name="id_skill")
    private Skill skill;
}
