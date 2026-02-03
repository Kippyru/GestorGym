package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;

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


    //Mapeo de Clase a ClaseDTO
    //Mapeo venta TODOCODE 1:20HS
    //Mapeo de Miembro a MiembroDTO

    //Mapeo de Pago a PagoDTO

    //

    //
}
