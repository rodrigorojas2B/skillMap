package com.skillmap.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SkillMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String grado;
    private int nivelBase;

    @ManyToOne
    private Rol rol;
    
    @ManyToOne
    private Skill skill;
}
