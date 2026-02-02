package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    //Rol
    private int id_rol;

}
