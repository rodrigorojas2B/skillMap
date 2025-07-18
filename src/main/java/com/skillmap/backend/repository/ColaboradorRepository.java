package com.skillmap.backend.repository;
import com.skillmap.backend.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
