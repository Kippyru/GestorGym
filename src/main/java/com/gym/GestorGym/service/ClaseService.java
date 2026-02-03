package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaseService {
    @Autowired
    private ClaseRepository claseRepository;

    public void crear(ClaseDTO claseDTO) {
        Clase clase = new Clase();
        clase.setDescripcion(claseDTO.getDescripcion());
        claseRepository.save(clase);
    }
}
