package com.gym.GestorGym.controllers;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
