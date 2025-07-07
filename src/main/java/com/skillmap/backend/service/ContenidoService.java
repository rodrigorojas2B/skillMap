package com.skillmap.backend.service;
import com.skillmap.backend.model.Contenido;
import com.skillmap.backend.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;
    public Contenido save(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }
    public Contenido get(Long id) {
        return contenidoRepository.findById(id).orElse(null);
    }
    public Contenido update(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }
    public void delete(Long id) {
        contenidoRepository.deleteById(id);
    }
}
