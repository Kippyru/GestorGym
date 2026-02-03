package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {

    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private Integer duracion;
}
