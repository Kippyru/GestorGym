package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.dto.PersonaDTO;

import java.util.List;

public interface IClaseService {

    List<ClaseDTO> traerClase();
    ClaseDTO buscarId(Integer id);
    ClaseDTO crearClase(ClaseDTO claseDto);
    ClaseDTO actualizarClase(Integer id, ClaseDTO claseDto);
    void eliminarClase(Integer id);

}
