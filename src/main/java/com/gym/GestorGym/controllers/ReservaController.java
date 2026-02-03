package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public List<Reserva> lista(){
        return reservaService.lista();
    }

    @GetMapping("/listid")
    public Reserva listid(@PathVariable int id) {
        return reservaService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody ReservaDTO reservaDTO) {
        reservaService.update(id, reservaDTO);
        return "Reserva Actualizada";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        reservaService.delete(id);
        return "Reserva Eliminada";
    }
}
