package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import com.gym.GestorGym.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;
    @PostMapping("/crear")
    public String crear(@RequestBody PlanDTO planDTO){
        planService.crear(planDTO);
        return "Plan Creado";
    }

    @GetMapping("/list")
    public List<Plan> lista(){
        return planService.lista();
    }

    @GetMapping("/listid")
    public Plan listid(@PathVariable int id) {
        return planService.listaId(id);
    }

    @PutMapping("/update")
    public String update(@PathVariable int id,
                         @RequestBody PlanDTO planDTO) {
        planService.update(id, planDTO);
        return "Plan Actualizado";
    }

    @DeleteMapping("/delete")
    public String eliminar(@PathVariable int id) {
        planService.delete(id);
        return "Plan Eliminado";
    }
}
