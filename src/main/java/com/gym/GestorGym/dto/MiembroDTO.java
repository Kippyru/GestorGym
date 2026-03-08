package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Persona;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiembroDTO {
    private int id_miembro;
    private boolean estado;
    private LocalDate fecha_ingreso;
    private Integer id_persona;
}
