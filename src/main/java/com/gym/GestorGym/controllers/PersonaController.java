package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public String crear(@RequestBody PersonaDTO personaDTO) {
        personaService.crear(personaDTO);

        return "Persona Creada";
    }
}
