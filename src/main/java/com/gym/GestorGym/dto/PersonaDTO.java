package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Rol;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer id_rol;

}
