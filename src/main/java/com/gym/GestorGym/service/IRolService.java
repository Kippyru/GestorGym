package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.RolDTO;

import java.util.List;

public interface IRolService {


    List<RolDTO> traerRol();
    RolDTO buscarId(Integer id_rol);
    RolDTO crearRol(RolDTO rolDto);
    RolDTO actualizarRol(Integer id_rol, RolDTO rolDto);
    void eliminarRol(Integer id_rol);



}
