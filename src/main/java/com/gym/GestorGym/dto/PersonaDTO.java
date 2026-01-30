package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private int id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
}
