package com.gym.GestorGym.mapper;


import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
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
    ClaseRepository claseRepository;

    @Mapping(target = "id_clase", source = "idClase", qualifiedByName = "mapIdToClase")
    public abstract Clase toEntity(ClaseDTO claseDTO);

    @Mapping(target = "id_clase", source = "idClase")
    public abstract ClaseDTO toDTO(Clase clase);

    @Named("mapIdToClase")
    protected Clase mapIdToClase (Integer id_clase){
        if (id_clase == null) return null;
        return claseRepository.findById(id_clase)
                .orElseThrow(()->new RuntimeException("Clase no encontrada"));
    }

    @Mapping(target = "id_clase", source = "idClase", qualifiedByName = "mapIdToClase")
    public abstract void updateClase(ClaseDTO dto, @MappingTarget Clase clase);

    public abstract List<ClaseDTO> toList (List<Clase>listaClase);

}
