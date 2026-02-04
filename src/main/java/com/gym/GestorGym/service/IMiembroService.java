package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Miembro;

import java.util.List;

public interface IMiembroService {


    List<MiembroDTO> traerMiembro();
    MiembroDTO crearMiembro(MiembroDTO miembroDto);
    MiembroDTO actualizarMiembro(Integer id_miembro, MiembroDTO miembroDto);
    void eliminarMiembro(Integer id_miembro);


}
