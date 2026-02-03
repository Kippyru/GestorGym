package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Persona> lista(){
        return personaRepository.findAll();
    }

    public Persona listaId(int id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public void update(int id, PersonaDTO personaDTO) {
        Persona persona = listaId(id);
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setEmail(personaDTO.getEmail());
        persona.setContraseña(personaDTO.getContraseña());
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }
}
