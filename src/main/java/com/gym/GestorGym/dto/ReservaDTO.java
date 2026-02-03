package com.gym.GestorGym.dto;

import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Integer id;
    private Instant fechaReserva;
    private Integer idMiembro;
    private Integer idTurno;
}
