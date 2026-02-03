package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.MiembroRepository;
import com.gym.GestorGym.repository.ReservaRepository;
import com.gym.GestorGym.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private MiembroRepository miembroRepository;

    public void crear(ReservaDTO reservaDTO) {

        Miembro miembro = miembroRepository.findById(reservaDTO.getIdMiembro())
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        Turno turno = turnoRepository.findById(reservaDTO.getIdTurno())
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(reservaDTO.getFechaReserva());
        reserva.setIdMiembro(miembro);
        reserva.setIdTurno(turno);
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

        if (reservaDTO.getIdMiembro() != null) {
            Miembro miembro = miembroRepository.findById(reservaDTO.getIdMiembro())
                    .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
            reserva.setIdMiembro(miembro);
        }

        if (reservaDTO.getIdTurno() != null) {
            Turno turno = turnoRepository.findById(reservaDTO.getIdTurno())
                    .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
            reserva.setIdTurno(turno);
        }

        reservaRepository.save(reserva);
    }

    public void delete(int id){
        reservaRepository.deleteById(id);
    }
}
