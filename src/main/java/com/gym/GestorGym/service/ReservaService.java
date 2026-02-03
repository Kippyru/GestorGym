package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Reserva> lista(){
        return reservaRepository.findAll();
    }

    public Reserva listaId(int id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public void update(int id, ReservaDTO reservaDTO) {
        Reserva reserva = listaId(id);
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setIdMiembro(reservaDTO.getIdMiembro());
        reserva.setIdTurno(reservaDTO.getIdTurno());
        reservaRepository.save(reserva);
    }

    public void delete(int id){
        reservaRepository.deleteById(id);
    }
}
