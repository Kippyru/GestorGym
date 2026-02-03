package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import com.gym.GestorGym.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public void crear(PlanDTO planDTO) {
       Plan plan = new Plan();
       plan.setNombre(planDTO.getNombre());
       plan.setDuracion(planDTO.getDuracion());
       plan.setPrecio(planDTO.getPrecio());
       planRepository.save(plan);
    }
}
