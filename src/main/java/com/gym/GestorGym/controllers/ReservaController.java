package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ReservaDTO reservaDTO) {
        reservaService.crear(reservaDTO);
        return ResponseEntity.ok("Reserva Creada");
    }

    @GetMapping("/list")
    public List<ReservaDTO> lista(){
        return reservaService.lista();
    }

    @GetMapping("/list/{id}")
    public ReservaDTO listaId(@PathVariable int id) {
        return reservaService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody ReservaDTO reservaDTO) {
        reservaService.update(id, reservaDTO);
        return ResponseEntity.ok("Reserva Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        reservaService.delete(id);
        return ResponseEntity.ok("Reserva Eliminada");
    }
}
