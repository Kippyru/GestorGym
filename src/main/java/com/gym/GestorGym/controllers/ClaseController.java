package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/list")
    public List<Clase> lista(){
        return claseService.lista();
    }

    @GetMapping("/listid")
    public Clase listid(@PathVariable int id) {
        return claseService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody ClaseDTO claseDTO) {
        claseService.update(id, claseDTO);
        return "Clase Actualizada";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        claseService.delete(id);
        return "Clase Eliminada";
    }
}
