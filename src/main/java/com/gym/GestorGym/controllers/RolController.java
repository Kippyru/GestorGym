package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody RolDTO rolDTO) {
        rolService.crear(rolDTO);

        return ResponseEntity.ok("Rol creado");
    }

    @GetMapping("/list")
    public List<RolDTO> lista(){
        return rolService.lista();
    }

    @GetMapping("/list/{id}")
    public RolDTO listaId(@PathVariable int id) {
        return rolService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody RolDTO rolDTO) {
        rolService.update(id, rolDTO);
        return ResponseEntity.ok("Rol Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        rolService.delete(id);
        return ResponseEntity.ok("Rol Eliminado");
    }
}
