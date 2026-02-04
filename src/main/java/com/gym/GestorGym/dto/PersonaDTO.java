package com.gym.GestorGym.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDTO {
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    //Rol
    private Integer id_rol;

}
