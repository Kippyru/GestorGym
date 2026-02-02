package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//DTO solo para transferir datos,uso interno o dar respuestas
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaseDTO {
    private long id_clase;
    private String descripcion;
}
