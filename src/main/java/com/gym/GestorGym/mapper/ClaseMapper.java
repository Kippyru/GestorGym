package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.repository.ClaseRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class ClaseMapper {

    @Autowired
    protected ClaseRepository claseRepository;



    public abstract Clase toEntity (ClaseDTO claseDto);

    public abstract ClaseDTO toDto (Clase clase);

    @Named("mapIdToClase")
    protected Clase mapIdToClase (Integer id){
        if (id == null) return null;
        return claseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no encontrado"));
    }

    public abstract void updateClase (ClaseDTO claseDto, @MappingTarget Clase entity);

    public abstract List<ClaseDTO> toList (List<Clase>listaClase);

}
