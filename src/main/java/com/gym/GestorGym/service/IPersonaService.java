package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {

     List<PersonaDTO> traerPersonas();
     PersonaDTO buscarId(Integer id_persona);
     PersonaDTO crearPersona(PersonaDTO personaDto);
     PersonaDTO actualizarPersona(Integer id_persona, PersonaDTO personaDto);
     void eliminarPersona(Integer id_persona);

}
