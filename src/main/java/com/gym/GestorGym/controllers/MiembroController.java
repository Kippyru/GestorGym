package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miembro")
public class MiembroController {
    @Autowired
    private MiembroService miembroService;
    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody MiembroDTO miembroDTO){
        miembroService.crear(miembroDTO);

        return ResponseEntity.ok("Miembro Creado");
    }

    @GetMapping("/list")
    public List<MiembroDTO> lista(){
        return miembroService.lista();
    }

    @GetMapping("/list/{id}")
    public MiembroDTO listid(@PathVariable int id) {
        return miembroService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody MiembroDTO miembroDTO) {
        miembroService.update(id, miembroDTO);
        return ResponseEntity.ok("Miembro Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        miembroService.delete(id);
        return ResponseEntity.ok("Miembro Eliminado");
    }

}
