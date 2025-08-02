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

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skill_fit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date fecha_autoeval;

    @Column(nullable = false)
    private Date fecha_calibracion;

    @Column(length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name="id_calibrador")
    private Colaborador calibrador;
}
