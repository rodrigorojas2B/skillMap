package com.skillmap.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillmap.backend.model.Rol;
public interface RolRepository extends JpaRepository<Rol, Long> {
}
