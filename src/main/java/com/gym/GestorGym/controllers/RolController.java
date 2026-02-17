package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> traerRol() {
        return ResponseEntity.ok(rolService.traerRol());
    }

    @GetMapping ("/lista/{id}")
    public RolDTO buscarId (@PathVariable Integer id){
        return rolService.buscarId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<RolDTO> crearRol(@RequestBody RolDTO dto) {
        // El Controller NO busca en el repo, solo delega al Service
        RolDTO creado = rolService.crearRol(dto);
        return ResponseEntity.created(URI.create("/api/rol/" + creado.getId_rol())).body(creado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable("id") Integer id, @RequestBody RolDTO dto) {
        return ResponseEntity.ok(rolService.actualizarRol(id, dto));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarRol(@PathVariable("id") Integer id) {
        rolService.eliminarRol(id);
        return ResponseEntity.ok("ID ELIMINADO");
    }

}
