package com.skillmap.backend.service;
import com.skillmap.backend.model.Colaborador;
import com.skillmap.backend.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    public Colaborador createColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
    public List<Colaborador> getAllColaboradores() {
        return colaboradorRepository.findAll();
    }
    public Optional<Colaborador> getColaboradorById(Long id) {
        return colaboradorRepository.findById(id);
    }
    public Colaborador updateColaborador(Long id, Colaborador colaboradorDetails) {
        Optional<Colaborador> optionalColaborador = colaboradorRepository.findById(id);
        if (!optionalColaborador.isPresent()) {
            return null;
        }
        colaboradorDetails.setId(id);
        return colaboradorRepository.save(colaboradorDetails);
    }
    public void deleteColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
