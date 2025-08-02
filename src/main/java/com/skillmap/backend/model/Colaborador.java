package com.skillmap.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@NoArgsConstructor
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(length = 30)
    private String paterno;

    @Column(length = 30)
    private String materno;

    @Column(nullable = false)
    private Boolean vigente;

    @Column
    private String id_calibrador_actual;
}
