package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Clase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private Integer id;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer cupos;
    private Integer idClase;

}
