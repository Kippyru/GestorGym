package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {
    @Autowired
    private MiembroRepository miembroRepository;

    public void crear(MiembroDTO miembroDTO) {
        Miembro miembro = new Miembro();
        miembro.setEstado(miembroDTO.getEstado());
        miembro.setFechaIngreso(miembroDTO.getFechaingreso());
        miembro.setIdPersona(miembroDTO.getIdpersona());
        miembroRepository.save(miembro);
    }

    public List<Miembro> lista(){
        return miembroRepository.findAll();
    }

    public Miembro listaId(int id) {
        return miembroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
    }

    public void update(int id, MiembroDTO miembroDTO) {
        Miembro miembro = listaId(id);
        miembro.setEstado(miembroDTO.getEstado());
        miembro.setFechaIngreso(miembroDTO.getFechaingreso());
        miembro.setIdPersona(miembroDTO.getIdpersona());
        miembroRepository.save(miembro);
    }

    public void delete(int id) {
        miembroRepository.deleteById(id);
    }
}
