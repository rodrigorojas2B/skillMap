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
@Table(name = "contenido")
@Getter
@Setter
@NoArgsConstructor
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private String url_curso;

    @Column(nullable = false)
    private String url_test;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;
}
