package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PersonaMapper {

    @Autowired
    protected RolRepository rolRepository;

    @Mapping(target = "idRol", source = "idRol", qualifiedByName = "mapIdToRol")
    public abstract Persona toEntity(PersonaDTO dto);

    @Mapping(target = "idRol", source = "idRol.id")
    public abstract PersonaDTO toDto(Persona persona);

    @Named("mapIdToRol")
    protected Rol mapIdToRol(Integer idRol) {
        if (idRol == null) return null;
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    @Mapping(target = "idRol", source = "idRol", qualifiedByName = "mapIdToRol")
    public abstract void updateEntityFromDto(PersonaDTO dto, @MappingTarget Persona entity);

    public abstract List<PersonaDTO> toDtoList(List<Persona> personas);
}
