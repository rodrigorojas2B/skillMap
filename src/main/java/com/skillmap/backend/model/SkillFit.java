package com.skillmap.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill_fit")
public class SkillFit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_autoeval")
    private Date fechaAutoeval;

    @Column(name = "fecha_calibracion")
    private Date fechaCalibracion;

    @Column(length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "id_calibrador")
    private Colaborador calibrador;

    @OneToMany(mappedBy = "skillFit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SkillEval> skillEvals;
}
