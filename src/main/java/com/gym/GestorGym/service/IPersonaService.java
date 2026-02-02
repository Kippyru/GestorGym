package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {

     List<PersonaDTO> traerPersonas();
     PersonaDTO crearPersona(PersonaDTO personaDto);
     PersonaDTO actualizarPersona(Long id_persona, PersonaDTO personaDto);
     void eliminarPersona(Long id_persona);



}
