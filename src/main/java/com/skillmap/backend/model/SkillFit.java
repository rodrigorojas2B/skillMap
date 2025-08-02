package com.skillmap.backend.model;

import java.util.Date;
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
public class SkillFit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_autoeval")
    private Date fechaAutoeval;

    @Column(name = "fecha_calibracion")
    private Date fechaCalibracion;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name="id_calibrador")
    private Colaborador calibrador;
}
