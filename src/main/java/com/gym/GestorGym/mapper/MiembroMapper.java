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
    protected PersonaRepository repo;

    @Mapping(target = "id_persona", source = "id_persona", qualifiedByName = "mapIdToPersona")
    public abstract Miembro toEntity(MiembroDTO dto);

    @Mapping(target = "id_persona", source = "id_persona.id_persona")
    public abstract MiembroDTO toDTO (Miembro miembro);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona (Integer id_persona){
        if (id_persona == null) return null;
        return repo.findById(id_persona)
                .orElseThrow(()->new RuntimeException("Persona no encontrado"));
    }

    @Mapping(target = "id_persona", source = "id_persona", qualifiedByName = "mapIdToPersona")
    public abstract void updateMiembro(MiembroDTO dto, @MappingTarget Miembro miembro);

    public abstract List<MiembroDTO>toList (List<Miembro>listaMiembro);

}
