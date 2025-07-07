package com.skillmap.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.repository.ColaboradorRepository;
@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;
    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }
    public Colaborador save(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
    public Iterable<Colaborador> getAll() {
        return colaboradorRepository.findAll();
    }
    public Colaborador getById(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
