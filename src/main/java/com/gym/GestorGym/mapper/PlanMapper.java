package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    Plan toEntity(PlanDTO planDTO);

    PlanDTO toDto(Plan plan);

    List<PlanDTO> planList(List<Plan> plans);

    void updatePlan(PlanDTO planDTO, @MappingTarget Plan plan);


}
