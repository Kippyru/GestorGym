package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Mapper(componentModel = "spring")
public abstract class PersonaMapper {

    @Autowired
    protected RolRepository rolRepository;

    @Mapping(target = "rol" , source = "id_rol" , qualifiedByName = "mapIdToRol")
        public abstract Persona toEntity (PersonaDTO personaDto);

    @Mapping(target = "id_rol" , source = "rol.id_rol")
        public abstract PersonaDTO toDto (Persona persona);

    @Named("mapIdToRol")
    protected Rol mapIdToRol (Integer id_rol){
        if (id_rol == null) return null;
        return rolRepository.findById(id_rol)
                .orElseThrow(()->new RuntimeException("Rol no encontrado"));
    }

    @Mapping(target = "rol" , source = "id_rol" , qualifiedByName = "mapIdToRol")
    public abstract void updatePersona (PersonaDTO personaDto, @MappingTarget Persona entity);

    public abstract List<PersonaDTO>toList (List<Persona>listaPersona);

}

