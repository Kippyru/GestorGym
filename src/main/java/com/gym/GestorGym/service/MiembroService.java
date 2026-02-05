package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.mapper.MiembroMapper;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {
    @Autowired
    private MiembroRepository miembroRepository;

    @Autowired
    private MiembroMapper miembroMapper;

    public void crear(MiembroDTO miembroDTO) {
        Miembro miembro = miembroMapper.toEntity(miembroDTO);
        miembroRepository.save(miembro);
    }

    public List<MiembroDTO> lista(){
        List<Miembro> miembros = miembroRepository.findAll();
        return miembroMapper.toDtoList(miembros);
    }

    public MiembroDTO listaId(int id) {
        Miembro miembro = miembroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
        return miembroMapper.toDto(miembro);
    }

    public MiembroDTO update(int id, MiembroDTO miembroDTO) {
        Miembro miembro = miembroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));

        miembroMapper.updateEntity(miembroDTO, miembro);

        Miembro actualizado = miembroRepository.save(miembro);
        return miembroMapper.toDto(actualizado);
    }

    public void delete(int id) {
        if (!miembroRepository.existsById(id)) {
            throw new RuntimeException("Miembro no encontrado");
        }
        miembroRepository.deleteById(id);
    }
}
