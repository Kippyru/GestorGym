package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.mapper.PersonaMapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    //crear
    public void crear(PersonaDTO personaDTO) {
        Persona persona = personaMapper.toEntity(personaDTO);
        personaRepository.save(persona);
    }

    //traer
    public List<PersonaDTO> lista() {
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.toDtoList(personas);
    }

    //buscar por id
    public PersonaDTO listaIdDto(int id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return personaMapper.toDto(persona);
    }

    //actualizar por id
    public PersonaDTO actualizar(Integer id, PersonaDTO dto) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        personaMapper.updateEntityFromDto(dto, persona);

        Persona actualizada = personaRepository.save(persona);
        return personaMapper.toDto(actualizada);
    }

    //borrar
    public void eliminar(Integer id) {
        if (!personaRepository.existsById(id)) {
            throw new RuntimeException("Persona no encontrada");
        }
        personaRepository.deleteById(id);
    }
}
