package com.skillmap.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(length = 30)
    private String paterno;

    @Column(length = 30)
    private String materno;

    @Column(nullable = false)
    private boolean vigente;

    @ManyToOne
    @JoinColumn(name = "id_calibrador_actual")
    private Colaborador calibrador;

    @OneToMany(mappedBy = "colaborador")
    private Set<SkillFit> skillFits;

    @OneToMany(mappedBy = "calibrador")
    private Set<SkillFit> calibraciones;
}
