package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miembro")
public class MiembroController {
    @Autowired
    private MiembroService miembroService;
    @PostMapping("/crear")
    public String crear(@RequestBody MiembroDTO miembroDTO){
        miembroService.crear(miembroDTO);

        return "Miembro Creado";
    }

    @GetMapping("/list")
    public List<Miembro> lista(){
        return miembroService.lista();
    }

    @GetMapping("/listid")
    public Miembro listid(@PathVariable int id) {
        return miembroService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody MiembroDTO miembroDTO) {
        miembroService.update(id, miembroDTO);
        return "Miembro Actualizado";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        miembroService.delete(id);
        return "Miembro Eliminado";
    }

}
