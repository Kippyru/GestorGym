package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.mapper.TurnoMapper;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.ClaseRepository;
import com.gym.GestorGym.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private TurnoMapper turnoMapper;

    public void crear(TurnoDTO turnoDTO) {
        Turno turno = turnoMapper.toEntity(turnoDTO);
        turnoRepository.save(turno);
    }

    public List<TurnoDTO> lista() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnoMapper.turnoList(turnos);
    }

    public TurnoDTO listaIdDto(int id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        return turnoMapper.toDto(turno);
    }

    public TurnoDTO actualizar(Integer id, TurnoDTO turnoDTO) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        turnoMapper.updateTurno(turnoDTO, turno);

        Turno actualizada = turnoRepository.save(turno);
        return turnoMapper.toDto(actualizada);
    }

    public void delete(int id){
        if (!turnoRepository.existsById(id)) {
            throw new RuntimeException("Turno no encontrado");
        }
        turnoRepository.deleteById(id);
    }
}
