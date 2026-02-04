package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;

public class Mapper {

    //Mapeo de Persona a PersonaDTO
    public static PersonaDTO toDTO(Persona p){
        if (p==null) return null;

        return PersonaDTO.builder()
                .id_persona(p.getId_persona())
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .email(p.getEmail() )
                .contraseña(p.getContraseña())
                .build();
    }

    //Mapeo de Rol a RolDTO
    public static RolDTO toDTO(Rol r){
        if (r==null) return null;

        return RolDTO.builder()
                .id_rol(r.getId_rol())
                .nombre(r.getNombre())
                .build();
    }

    //Mapeo de Miembro a MiembroDTO
    public static MiembroDTO toDTO(Miembro m){
        if (m==null) return null;

        return MiembroDTO.builder()
                .id_miembro(m.getId_miembro())
                .estado(m.isEstado())
                .fecha_ingreso(m.getFecha_ingreso())
                .build();
    }

    //Mapeo de Clase a ClaseDTO
    //Mapeo venta TODOCODE 1:20HS
    //Mapeo de Miembro a MiembroDTO

    //Mapeo de Pago a PagoDTO

    //

    //
}
