package com.skillmap.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Entity
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(1)
    @Max(5)
    private Integer nivel;
    @NotNull
    @Column(length = 500)
    private String url_curso;
    @NotNull
    @Column(length = 500)
    private String url_test;
    @NotNull
    private Long skill_id;
    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNivel() {
        return nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public String getUrl_curso() {
        return url_curso;
    }
    public void setUrl_curso(String url_curso) {
        this.url_curso = url_curso;
    }
    public String getUrl_test() {
        return url_test;
    }
    public void setUrl_test(String url_test) {
        this.url_test = url_test;
    }
    public Long getSkill_id() {
        return skill_id;
    }
    public void setSkill_id(Long skill_id) {
        this.skill_id = skill_id;
    }
}
