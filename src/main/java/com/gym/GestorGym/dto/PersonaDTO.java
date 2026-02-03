package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private Integer idRol;
}
