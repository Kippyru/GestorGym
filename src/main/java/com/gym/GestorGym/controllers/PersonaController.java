package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public List<Persona> lista(){
        return personaService.lista();
    }

    @GetMapping("/listid")
    public Persona listid(@PathVariable int id) {
        return personaService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody PersonaDTO personaDTO) {
        personaService.update(id, personaDTO);
        return "Persona Actualizada";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        personaService.delete(id);
        return "Persona Eliminada";
    }

}
