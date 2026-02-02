package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.Staff;
import com.gym.GestorGym.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public void crear(StaffDTO staffDTO) {
        Staff staff = new Staff();

        staff.setArea(staffDTO.getArea());
        staff.setIdPersona(staffDTO.getIdPersona());
        staff.setIdTurno(staffDTO.getIdTurno());
        staffRepository.save(staff);
    }
}
