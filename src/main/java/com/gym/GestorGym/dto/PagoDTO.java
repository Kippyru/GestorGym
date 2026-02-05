package com.gym.GestorGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private Integer id;
    private BigDecimal monto;
    private LocalDate fechaPago;
    private Integer idMiembro;
    private Integer idPlan;
}
