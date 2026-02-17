package com.gym.GestorGym.service;


import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.PersonaMapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repo;

    @Autowired
    private PersonaMapper personaMapper;

    public List<PersonaDTO> traerPersonas() {
        List<Persona>listaPersona = repo.findAll();
        return personaMapper.toList(listaPersona);
    }

    public PersonaDTO buscarId(Integer id_persona){
        Persona per = repo.findById(id_persona)
                .orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        return personaMapper.toDto(per);
    }

    public PersonaDTO crearPersona(PersonaDTO personaDto) {
        Persona per = personaMapper.toEntity(personaDto);
        repo.save(per);
        return personaDto;
    }

    public PersonaDTO actualizarPersona(Integer id_persona, PersonaDTO personaDto) {

        Persona per = repo.findById(id_persona)
                .orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        personaMapper.updatePersona(personaDto, per);
        Persona perU = repo.save(per);

        return personaMapper.toDto(perU);
    }

    public void eliminarPersona(Integer id_persona) {
        if (!repo.existsById(id_persona)){
            throw new NotFoundException("Persona no encontrada para eliminar");
        }

        repo.deleteById(id_persona);
    }

}
