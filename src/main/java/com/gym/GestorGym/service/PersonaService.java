package com.gym.GestorGym.service;


import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.mapper.Mapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repo;

    @Override
    public List<PersonaDTO> traerPersonas() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDto) {
        var prod = Persona.builder()
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .email(personaDto.getEmail())
                .contraseña(personaDto.getContraseña())
                .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public PersonaDTO actualizarPersona(Long id_persona, PersonaDTO personaDto) {
        return null;
    }

    @Override
    public void eliminarPersona(Long id_persona) {

    }
}
