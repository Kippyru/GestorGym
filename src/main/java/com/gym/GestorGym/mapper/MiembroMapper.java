package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.MiembroDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.repository.PersonaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MiembroMapper {
    @Autowired
    protected PersonaRepository personaRepository;

    @Mapping(target = "idPersona", source = "idpersona", qualifiedByName = "mapIdToPersona")
    public abstract Miembro toEntity(MiembroDTO miembroDTO);

    @Mapping(target = "idpersona", source = "idPersona.id")
    public abstract MiembroDTO toDto(Miembro miembro);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona(Integer idPersona) {
        if (idPersona == null) return null;
        return personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Mapping(target = "idPersona", source = "idpersona", qualifiedByName = "mapIdToPersona")
    public abstract void updateEntity(MiembroDTO miembroDTO, @MappingTarget Miembro entity);

    public abstract List<MiembroDTO> toDtoList(List<Miembro> miembros);
}
