package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clase")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ClaseDTO claseDTO){
        claseService.crear(claseDTO);
        return ResponseEntity.ok( "Clase Creada");
    }
    @GetMapping("/list")
    public List<ClaseDTO> lista(){
        return claseService.lista();
    }

    @GetMapping("/list/{id}")
    public ClaseDTO listaId(@PathVariable int id) {
        return claseService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody ClaseDTO claseDTO) {
        claseService.update(id, claseDTO);
        return ResponseEntity.ok( "Clase Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        claseService.delete(id);
        return ResponseEntity.ok("Clase Eliminada");
    }
}
