package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PagoDTO;
import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.*;
import com.gym.GestorGym.repository.MiembroRepository;
import com.gym.GestorGym.repository.PlanRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PagoMapper {

    @Autowired
    protected PlanRepository planRepository;
    @Autowired
    protected MiembroRepository miembroRepository;

    @Mapping(target = "id_plan", source = "id_plan", qualifiedByName = "mapIdToPlan")
    @Mapping(target = "id_miembro", source = "id_miembro", qualifiedByName = "mapIdToMiembro")
    public abstract Pago toEntity (PagoDTO pagoDTO);

    @Mapping(target = "id_plan", source = "id_plan.id_plan")
    @Mapping(target = "id_miembro", source = "id_miembro.id_miembro")
    public abstract PagoDTO toDto (Pago pago);

    @Named("mapIdToPlan")
    protected Plan mapIdToPlan (Integer id_plan){
        if (id_plan == null) return null;
        return planRepository.findById(id_plan)
                .orElseThrow(()->new RuntimeException("Plan no encontrado"));
    }

    @Named("mapIdToMiembro")
    protected Miembro mapIdToMiembro (Integer id_miembro){
        if (id_miembro == null) return null;
        return miembroRepository.findById(id_miembro)
                .orElseThrow(()->new RuntimeException("Miembro no encontrado"));
    }

    @Mapping(target = "id_plan", source = "id_plan", qualifiedByName = "mapIdToPlan")
    @Mapping(target = "id_miembro", source = "id_miembro", qualifiedByName = "mapIdToMiembro")
    public abstract void updatePago (PagoDTO pagoDTO, @MappingTarget Pago entity);

    public abstract List<PagoDTO> toList (List<Pago>listaPago);

}
