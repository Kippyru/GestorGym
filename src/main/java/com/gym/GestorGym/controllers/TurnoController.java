package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public List<Turno> lista(){
        return turnoService.lista();
    }

    @GetMapping("/listid")
    public Turno listid(@PathVariable int id) {
        return turnoService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody TurnoDTO turnoDTO) {
        turnoService.update(id, turnoDTO);
        return "Turno Actualizado";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        turnoService.delete(id);
        return "Turno Eliminado";
    }
}
