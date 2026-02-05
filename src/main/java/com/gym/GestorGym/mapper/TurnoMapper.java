package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.TurnoDTO;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.ClaseRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TurnoMapper {
    @Autowired
    protected ClaseRepository claseRepository;

    @Mapping(target = "idClase", source = "idClase", qualifiedByName = "mapIdToClase")
    public abstract Turno toEntity(TurnoDTO turnoDTO);

    @Mapping(target = "idClase", source = "idClase.id")
    public abstract TurnoDTO toDto(Turno turno);

    @Named("mapIdToClase")
    protected Clase mapIdToClase(Integer idClase) {
        if (idClase == null) return null;
        return claseRepository.findById(idClase)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    @Mapping(target = "idClase", source = "idClase", qualifiedByName = "mapIdToClase")
    public abstract void updateTurno(TurnoDTO turnoDTO, @MappingTarget Turno entity);

    public abstract List<TurnoDTO> turnoList(List<Turno> turnos);
}
