package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.Staff;
import com.gym.GestorGym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody StaffDTO staffDTO) {
        staffService.crear(staffDTO);
        return ResponseEntity.ok("Staff Creado");
    }

    @GetMapping("/list")
    public List<Staff> lista(){
        return staffService.lista();
    }

    @GetMapping("/listid")
    public Staff listaId(@PathVariable int id) {
        return staffService.listaId(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody StaffDTO staffDTO) {
        staffService.update(id, staffDTO);
        return ResponseEntity.ok("Staff Actualizado");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@PathVariable int id) {
        staffService.delete(id);
        return ResponseEntity.ok("Staff Eliminado");
    }
}
