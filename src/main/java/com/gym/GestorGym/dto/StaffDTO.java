package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    private Integer id;
    private String area;
    private Integer idPersona;
    private Integer idTurno;
}
