package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.mapper.PlanMapper;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.models.Plan;
import com.gym.GestorGym.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PlanMapper planMapper;

    public void crear(PlanDTO planDTO) {
       Plan plan = planMapper.toEntity(planDTO);
       planRepository.save(plan);
    }

    public List<PlanDTO> lista(){
        List<Plan> plans = planRepository.findAll();
        return planMapper.planList(plans);
    }

    public PlanDTO listaId(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        return planMapper.toDto(plan);
    }

    public PlanDTO update(int id, PlanDTO planDTO) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        planMapper.updatePlan(planDTO, plan);
        Plan actualizado = planRepository.save(plan);
        return planMapper.toDto(actualizado);
    }

    public void delete(int id){
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Plan no encontrado");
        }
        planRepository.deleteById(id);
    }
}
