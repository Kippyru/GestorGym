package com.gym.GestorGym.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MiembroDTO {
    private int id_miembro;
    private boolean estado;
    private LocalDate fecha_ingreso;
}
