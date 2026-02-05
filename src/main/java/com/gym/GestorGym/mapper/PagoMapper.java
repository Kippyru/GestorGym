package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PagoDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Pago;
import com.gym.GestorGym.models.Plan;
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
    protected MiembroRepository miembroRepository;
    @Autowired
    protected PlanRepository planRepository;

    @Mapping(target = "idMiembro", source = "idMiembro", qualifiedByName = "mapIdToMiembro")
    @Mapping(target = "idPlan", source = "idPlan", qualifiedByName = "mapIdToPlan")
    public abstract Pago toEntity(PagoDTO pagoDTO);

    @Mapping(target = "idMiembro", source = "idMiembro.id")
    @Mapping(target = "idPlan", source = "idPlan.id")
    public abstract PagoDTO toDto(Pago pago);

    @Named("mapIdToMiembro")
    protected Miembro mapIdToMiembro(Integer idMiembro) {
        if (idMiembro == null) return null;
        return miembroRepository.findById(idMiembro)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
    }

    @Named("mapIdToPlan")
    protected Plan mapIdToPlan(Integer idPlan) {
        if (idPlan == null) return null;
        return planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }

    @Mapping(target = "idMiembro", source = "idMiembro", qualifiedByName = "mapIdToMiembro")
    @Mapping(target = "idPlan", source = "idPlan", qualifiedByName = "mapIdToPlan")
    public abstract void updatePago(PagoDTO pagoDTO, @MappingTarget Pago entity);

    public abstract List<PagoDTO> pagoList(List<Pago> pagos);

}
