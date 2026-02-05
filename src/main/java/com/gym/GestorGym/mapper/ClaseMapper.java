package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClaseMapper {

    Clase toEntity(ClaseDTO claseDTO);

    ClaseDTO toDto(Clase clase);

    List <ClaseDTO> toList(List<Clase> clases);

    void updateEntity(ClaseDTO claseDTO, @MappingTarget Clase clase);

}
