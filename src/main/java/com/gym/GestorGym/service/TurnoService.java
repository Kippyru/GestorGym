package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public void crear(TurnoDTO turnoDTO) {
        Turno turno = new Turno();
        turno.setCupos(turnoDTO.getCupos());
        turno.setHora(turnoDTO.getHora());
        turno.setFecha(turnoDTO.getFecha());
        turno.setIdClase(turnoDTO.getIdClase());
        turnoRepository.save(turno);
    }
}
