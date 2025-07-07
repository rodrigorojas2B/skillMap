package com.skillmap.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillmap.backend.model.Rol;
import com.skillmap.backend.repository.RolRepository;
@Service
public class RolService {
    private final RolRepository rolRepository;
    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }
    public Iterable<Rol> getAllRoles() {
        return rolRepository.findAll();
    }
}
