package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody PersonaDTO personaDTO) {
        personaService.crear(personaDTO);
        return ResponseEntity.ok("Persona Creada");
    }

    @GetMapping("/list")
    public List<PersonaDTO> lista() {
        // El service ahora debería devolver DTOs (mira la nota abajo)
        return personaService.lista();
    }

    @GetMapping("/list/{id}") // Corregido: añadida la variable en el path
    public PersonaDTO listid(@PathVariable int id) {
        return personaService.listaIdDto(id);
    }

    @PutMapping("/update/{id}") // Corregido: añadida la variable en el path
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody PersonaDTO personaDTO) {
        personaService.actualizar(id, personaDTO);
        return ResponseEntity.ok("Persona Actualizada");
    }

    @DeleteMapping("/delete/{id}") // Corregido: añadida la variable en el path
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        personaService.eliminar(id);
        return ResponseEntity.ok("Persona Eliminada");
    }
}
