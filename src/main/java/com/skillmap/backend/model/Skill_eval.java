package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skill_eval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nivel_autoeval;
    
    @Column(nullable = false)
    private Integer nivel_calibrado;

    @Column(length = 100)
    private String observaciones;

    @Column
    private BigDecimal nota_test;

    @Column
    private String url_evidencia;

    @ManyToOne
    @JoinColumn(name="id_skill_fit")
    private Skill_fit skill_fit;

    @ManyToOne
    @JoinColumn(name="id_skill")
    private Skill skill;
}
