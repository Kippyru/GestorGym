package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
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
public class PersonaController  {

    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> traerPersona () {

        return ResponseEntity.ok(personaService.traerPersonas());
    }
    @PostMapping
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO dto){
        PersonaDTO creado = personaService.crearPersona(dto);

        return ResponseEntity.created(URI.create("/api/persona" + creado.getId_persona())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona (@PathVariable Long id_persona,
                                                        @RequestBody PersonaDTO dto) {
        return ResponseEntity.ok(personaService.actualizarPersona(id_persona,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPersona (@PathVariable Long id_persona) {
        personaService.eliminarPersona(id_persona);
        return ResponseEntity.noContent().build();
    }


}
