package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/crear")
    public String crear(@RequestBody StaffDTO staffDTO) {
        staffService.crear(staffDTO);
        return "Staff Creado";
    }
}
