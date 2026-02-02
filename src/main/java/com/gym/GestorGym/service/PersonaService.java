package com.gym.GestorGym.service;


import com.gym.GestorGym.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaService implements IPersonaService {
    @Override
    public List<PersonaDTO> traerPersonas() {
        return List.of();
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDto) {
        return null;
    }

    @Override
    public PersonaDTO actualizarPersona(Long id_persona, PersonaDTO personaDto) {
        return null;
    }

    @Override
    public void eliminarPersona(Long id_persona) {

    }
}
