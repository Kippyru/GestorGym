package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clase")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @PostMapping("/crear")
    public String crear(@RequestBody ClaseDTO claseDTO){
        claseService.crear(claseDTO);
        return "Clase Creada";
    }
}
