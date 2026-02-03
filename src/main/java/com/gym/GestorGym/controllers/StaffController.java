package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.Staff;
import com.gym.GestorGym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/crear")
    public String crear(@RequestBody StaffDTO staffDTO) {
        staffService.crear(staffDTO);
        return "Staff Creado";
    }

    @GetMapping("/list")
    public List<Staff> lista(){
        return staffService.lista();
    }

    @GetMapping("/listid")
    public Staff listid(@PathVariable int id) {
        return staffService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody StaffDTO staffDTO) {
        staffService.update(id, staffDTO);
        return "Staff Actualizado";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        staffService.delete(id);
        return "Staff Eliminado";
    }
}
