package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.mapper.StaffMapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Reserva;
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
    private StaffMapper staffMapper;

    public void crear(StaffDTO staffDTO) {

        Staff staff = staffMapper.toEntity(staffDTO);
        staffRepository.save(staff);
    }

    public List<Staff> lista(){
        return staffRepository.findAll();
    }

    public Staff listaId(int id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
    }

    public StaffDTO update(Integer id, StaffDTO staffDTO) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));

        staffMapper.updateStaff(staffDTO, staff);

        Staff actualizada = staffRepository.save(staff);
        return staffMapper.toDto(actualizada);
    }

    public void delete(int id){
        if (!staffRepository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        staffRepository.deleteById(id);
    }
}
