package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crear")
    public String crear(@RequestBody TurnoDTO turnoDTO) {
        turnoService.crear(turnoDTO);
        return "Turno Creado";
    }
}
