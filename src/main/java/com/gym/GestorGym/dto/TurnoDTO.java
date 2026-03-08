package com.gym.GestorGym.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {

    private Integer id_turno;
    private LocalDate fecha;
    private LocalTime hora;
    private int cupos;
}
