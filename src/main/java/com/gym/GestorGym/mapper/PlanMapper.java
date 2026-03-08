package com.gym.GestorGym.mapper;


import com.gym.GestorGym.dto.PlanDTO;
import com.gym.GestorGym.models.Plan;
import com.gym.GestorGym.repository.PlanRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper (componentModel = "spring")
public abstract class PlanMapper {

    @Autowired
    protected PlanRepository planRepository;

    public abstract Plan toEntity (PlanDTO planDTO);

    public abstract PlanDTO toDto (Plan plan);



}
