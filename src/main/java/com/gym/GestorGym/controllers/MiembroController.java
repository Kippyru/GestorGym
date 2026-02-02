package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miembro")
public class MiembroController {
    @Autowired
    private MiembroService miembroService;
    @PostMapping("/crear")
    public String crear(@RequestBody MiembroDTO miembroDTO){
        miembroService.crear(miembroDTO);

        return "Miembro Creado";
    }


}
