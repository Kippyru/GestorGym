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
public class PagoDTO {
    private int id_pago;
    private int monto;
    private LocalDate fecha_pago;
    //plan
    private int id_plan;
    //miembro
    private int id_miembro;

}
