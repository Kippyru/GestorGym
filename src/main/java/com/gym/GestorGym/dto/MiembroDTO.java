package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiembroDTO {
    private Integer id_miembro;
    private String estado;
    private LocalDate fecha_ingreso;
    private Integer id_persona;
}
