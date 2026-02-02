package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
