package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.Mapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.service.IPersonaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


//controller-->service-->repository(mvc)
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> traerPersona() {
        return ResponseEntity.ok(personaService.traerPersonas());
    }

    @GetMapping ("/lista/{id}")
    public PersonaDTO buscarId (@PathVariable Integer id){
        return personaService.buscarId(id);
    }

    @PostMapping ("/crear")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO dto) {
        // El Controller NO busca en el repo, solo delega al Service
        PersonaDTO creado = personaService.crearPersona(dto);
        return ResponseEntity.created(URI.create("/api/persona/" + creado.getId_persona())).body(creado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable("id") Integer id, @RequestBody PersonaDTO dto) {
        return ResponseEntity.ok(personaService.actualizarPersona(id, dto));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarPersona(@PathVariable("id") Integer id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}