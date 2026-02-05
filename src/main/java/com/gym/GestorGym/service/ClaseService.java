package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.mapper.ClaseMapper;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {
    @Autowired
    private ClaseRepository claseRepository;
    @Autowired
    private ClaseMapper claseMapper;

    public void crear(ClaseDTO claseDTO) {
        Clase clase = claseMapper.toEntity(claseDTO);
        claseRepository.save(clase);
    }

    public List<ClaseDTO> lista(){
        List<Clase> clases = claseRepository.findAll();
        return claseMapper.toList((clases));
    }

    public ClaseDTO listaId(int id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        return claseMapper.toDto(clase);
    }

    public ClaseDTO update(int id, ClaseDTO claseDTO) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        claseMapper.updateEntity(claseDTO, clase);
        Clase actualizado = claseRepository.save(clase);
        return claseMapper.toDto(actualizado);
    }

    public void delete(int id) {
        if (!claseRepository.existsById(id)) {
            throw new RuntimeException("Clase no encontrada");
        }
        claseRepository.deleteById(id);
    }
}
