package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skill_map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String grado;

    @Column(nullable = false)
    private Integer nivel_base;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
}
