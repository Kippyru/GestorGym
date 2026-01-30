package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public void crear(PersonaDTO personaDTO) {

        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setEmail(personaDTO.getEmail());
        persona.setContraseña(personaDTO.getContraseña());
        personaRepository.save(persona);
    }
}
