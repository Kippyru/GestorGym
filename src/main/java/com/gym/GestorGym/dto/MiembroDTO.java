package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiembroDTO {
    private int id_miembro;
    private boolean estado;
    private LocalDate fecha_ingreso;
}
