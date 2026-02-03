package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import com.gym.GestorGym.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Plan> lista(){
        return planRepository.findAll();
    }

    public Plan listaId(int id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }

    public void update(int id, PlanDTO planDTO) {
        Plan plan = listaId(id);
        plan.setNombre(planDTO.getNombre());
        plan.setDuracion(planDTO.getDuracion());
        plan.setPrecio(planDTO.getPrecio());
        planRepository.save(plan);
    }

    public void delete(int id){
        planRepository.deleteById(id);
    }
}
