package com.skillmap.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int nivel;

    @Column(name = "url_curso")
    private String urlCurso;

    @Column(name = "url_test")
    private String urlTest;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
