package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Turno> lista(){
        return turnoRepository.findAll();
    }

    public Turno listaId(int id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }

    public void update(int id, TurnoDTO turnoDTO) {
        Turno turno = listaId(id);
        turno.setCupos(turnoDTO.getCupos());
        turno.setHora(turnoDTO.getHora());
        turno.setFecha(turnoDTO.getFecha());
        turno.setIdClase(turnoDTO.getIdClase());
        turnoRepository.save(turno);
    }

    public void delete(int id){
        turnoRepository.deleteById(id);
    }
}
