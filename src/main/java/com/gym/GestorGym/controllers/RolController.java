package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/crear")
    public String crear(@RequestBody RolDTO rolDTO) {
        rolService.crear(rolDTO);

        return "Rol creado";
    }

    @GetMapping("/list")
    public List<Rol> lista(){
        return rolService.lista();
    }

    @GetMapping("/listid")
    public Rol listid(@PathVariable int id) {
        return rolService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody RolDTO rolDTO) {
        rolService.update(id, rolDTO);
        return "Rol Actualizado";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        rolService.delete(id);
        return "Rol Eliminado";
    }
}
