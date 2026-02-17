package com.gym.GestorGym.controllers;
import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.service.IClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clase")
public class ClaseController {

    @Autowired
    private IClaseService claseService;

    @GetMapping
    public ResponseEntity<List<ClaseDTO>> traerClase() {
        return ResponseEntity.ok(claseService.traerClase());
    }

    @GetMapping ("/lista/{id}")
    public ClaseDTO buscarId (@PathVariable Integer id){
        return claseService.buscarId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<ClaseDTO> crearClase(@RequestBody ClaseDTO dto) {
        ClaseDTO creado = claseService.crearClase(dto);
        return ResponseEntity.created(URI.create("/api/clase/" + creado.getId_clase())).body(creado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClaseDTO> actualizarClase(@PathVariable("id") Integer id, @RequestBody ClaseDTO dto) {
        return ResponseEntity.ok(claseService.actualizarClase(id, dto));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarClase(@PathVariable("id") Integer id) {
        claseService.eliminarClase(id);
        return ResponseEntity.noContent().build();
    }

}
