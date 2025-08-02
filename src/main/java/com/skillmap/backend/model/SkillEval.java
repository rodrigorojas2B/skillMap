package com.skillmap.backend.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SkillEval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nivel_autoeval", nullable = false)
    private Integer nivelAutoeval;

    @Column(name = "nivel_calibrado", nullable = false)
    private Integer nivelCalibrado;

    @Column(name = "observaciones", length = 100)
    private String observaciones;

    @Column(name = "nota_test", precision = 5, scale = 2)
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
