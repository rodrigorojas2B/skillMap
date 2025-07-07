package com.skillmap.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skillmap.backend.model.Rol;
import com.skillmap.backend.service.RolService;
@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolService rolService;
    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol savedRol = rolService.saveRol(rol);
        return new ResponseEntity<>(savedRol, HttpStatus.CREATED);
    }
}
