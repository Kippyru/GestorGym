package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.mapper.ReservaMapper;
import com.gym.GestorGym.models.*;
import com.gym.GestorGym.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ReservaMapper reservaMapper;

    public void crear(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        reservaRepository.save(reserva);
    }

    public List<ReservaDTO> lista() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservaMapper.reservaList(reservas);
    }

    public ReservaDTO listaId(int id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return reservaMapper.toDto(reserva);
    }

    public ReservaDTO update(Integer id, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reservaMapper.updateReserva(reservaDTO, reserva);

        Reserva actualizada = reservaRepository.save(reserva);
        return reservaMapper.toDto(actualizada);
    }

    public void delete(int id){
        if (!reservaRepository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepository.deleteById(id);
    }
}
