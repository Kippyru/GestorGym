package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public void crear(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setIdMiembro(reservaDTO.getIdMiembro());
        reserva.setIdTurno(reservaDTO.getIdTurno());
        reservaRepository.save(reserva);
    }
}
