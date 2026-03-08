package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {

    private Integer id_plan;
    private String nombre;
    private int precio;
    private int duracion;

}
