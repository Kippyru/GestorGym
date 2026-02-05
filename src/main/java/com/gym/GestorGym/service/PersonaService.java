package com.gym.GestorGym.service;


import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.Mapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
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
        Persona persona = Mapper.toEntity(personaDto);
        return Mapper.toDTO(repo.save(persona));
    }


    @Override
    public PersonaDTO actualizarPersona(Integer id_persona, PersonaDTO personaDto) {

        Persona per = repo.findById(id_persona)
                .orElseThrow(() -> new NotFoundException("Persona no encontrada"));

        per.setNombre(personaDto.getNombre());
        per.setApellido(personaDto.getApellido());
        per.setEmail(personaDto.getEmail());
        per.setContraseña(personaDto.getContraseña());

        if (personaDto.getId_rol() != null) {
            per.setRol(
                    Rol.builder()
                            .id_rol(personaDto.getId_rol())
                            .build()
            );
        }

        return Mapper.toDTO(repo.save(per));
    }


    @Override
    public void eliminarPersona(Integer id_persona) {
        if (!repo.existsById(id_persona)){
            throw new NotFoundException("Persona no encontrada para eliminar");
        }

        repo.deleteById(id_persona);
    }
}
