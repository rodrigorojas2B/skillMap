package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Colaborador {
    @Id
    private String id;
    private String nombre;
    private String paterno;
    private String materno;
    private boolean vigente;

    @ManyToOne
    private Colaborador idCalibradorActual;
}
