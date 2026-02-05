package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody TurnoDTO turnoDTO) {
        turnoService.crear(turnoDTO);
        return ResponseEntity.ok("Turno Creado");
    }

    @GetMapping("/list")
    public List<TurnoDTO> lista(){
        return turnoService.lista();
    }

    @GetMapping("/list/{id}")
    public TurnoDTO listaIdDto(@PathVariable int id) {
        return turnoService.listaIdDto(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                         @RequestBody TurnoDTO turnoDTO) {
        turnoService.actualizar(id, turnoDTO);
        return ResponseEntity.ok("Turno Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        turnoService.delete(id);
        return ResponseEntity.ok("Turno Eliminado");
    }
}
