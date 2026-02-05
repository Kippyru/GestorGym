package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;
    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody PlanDTO planDTO){
        planService.crear(planDTO);
        return ResponseEntity.ok("Plan Creado");
    }

    @GetMapping("/list")
    public List<PlanDTO> lista(){
        return planService.lista();
    }

    @GetMapping("/list/{id}")
    public PlanDTO listaId(@PathVariable int id) {
        return planService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                         @RequestBody PlanDTO planDTO) {
        planService.update(id, planDTO);
        return ResponseEntity.ok("Plan Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        planService.delete(id);
        return ResponseEntity.ok("Plan Eliminado");
    }
}
