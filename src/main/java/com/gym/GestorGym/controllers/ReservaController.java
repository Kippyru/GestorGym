package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public String crear(@RequestBody ReservaDTO reservaDTO) {
        reservaService.crear(reservaDTO);
        return "Reserva Creada";
    }
}
