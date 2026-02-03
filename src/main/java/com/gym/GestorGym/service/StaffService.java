package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Staff;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.PersonaRepository;
import com.gym.GestorGym.repository.StaffRepository;
import com.gym.GestorGym.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    public void crear(StaffDTO staffDTO) {

        Persona persona = personaRepository.findById(staffDTO.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Turno turno = turnoRepository.findById(staffDTO.getIdTurno())
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        Staff staff = new Staff();

        staff.setArea(staffDTO.getArea());
        staff.setIdPersona(persona);
        staff.setIdTurno(turno);
        staffRepository.save(staff);
    }

    public List<Staff> lista(){
        return staffRepository.findAll();
    }

    public Staff listaId(int id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
    }

    public void update(int id, StaffDTO staffDTO) {
        Staff staff = listaId(id);
        staff.setArea(staffDTO.getArea());

        if (staffDTO.getIdPersona() != null) {
            Persona persona = personaRepository.findById(staffDTO.getIdPersona())
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
            staff.setIdPersona(persona);
        }

        if (staffDTO.getIdTurno() != null) {
            Turno turno = turnoRepository.findById(staffDTO.getIdTurno())
                    .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
            staff.setIdTurno(turno);
        }

        staffRepository.save(staff);
    }

    public void delete(int id){
        staffRepository.deleteById(id);
    }
}
