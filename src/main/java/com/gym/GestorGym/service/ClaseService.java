package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {
    @Autowired
    private ClaseRepository claseRepository;

    public void crear(ClaseDTO claseDTO) {
        Clase clase = new Clase();
        clase.setDescripcion(claseDTO.getDescripcion());
        claseRepository.save(clase);
    }

    public List<Clase> lista(){
        return claseRepository.findAll();
    }

    public Clase listaId(int id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    public void update(int id, ClaseDTO claseDTO) {
        Clase clase = listaId(id);
        clase.setDescripcion(claseDTO.getDescripcion());
        claseRepository.save(clase);
    }

    public void delete(int id) {
        claseRepository.deleteById(id);
    }
}
