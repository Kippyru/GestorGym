package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.repository.RolRepository;
import com.gym.GestorGym.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RolService rolService;

    @PostMapping("/crear")
    public String crear(@RequestBody RolDTO rolDTO) {
        rolService.crear(rolDTO);

        return "Rol creado";
    }

}
