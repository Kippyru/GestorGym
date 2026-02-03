package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.MiembroRepository;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {
    @Autowired
    private MiembroRepository miembroRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void crear(MiembroDTO miembroDTO) {
        Persona persona = personaRepository.findById(miembroDTO.getIdpersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Miembro miembro = new Miembro();
        miembro.setEstado(miembroDTO.getEstado());
        miembro.setFechaIngreso(miembroDTO.getFechaingreso());
        miembro.setIdPersona(persona);
        miembroRepository.save(miembro);
    }

    public List<Miembro> lista(){
        return miembroRepository.findAll();
    }

    public Miembro listaId(int id) {
        return miembroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public void update(int id, MiembroDTO miembroDTO) {

        Miembro miembro = listaId(id);
        miembro.setEstado(miembroDTO.getEstado());
        miembro.setFechaIngreso(miembroDTO.getFechaingreso());

        if (miembroDTO.getIdpersona() != null) {
            Persona persona = personaRepository.findById(miembroDTO.getIdpersona())
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
            miembro.setIdPersona(persona);
        }

        miembroRepository.save(miembro);
    }

    public void delete(int id) {
        miembroRepository.deleteById(id);
    }
}
