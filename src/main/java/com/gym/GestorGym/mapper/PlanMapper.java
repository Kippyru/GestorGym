package com.gym.GestorGym.mapper;


import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper (componentModel = "spring")
public abstract class PlanMapper {

    public abstract Plan toEntity (PlanDTO planDTO);

    public abstract PlanDTO toDto (Plan plan);

    public abstract void updatePlan (PlanDTO planDTO, @MappingTarget Plan entity);

    public abstract List<PlanDTO> toList (List<Plan>listaPlan);

}
