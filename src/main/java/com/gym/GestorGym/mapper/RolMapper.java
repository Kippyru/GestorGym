package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface RolMapper {

    Rol toEntity(RolDTO rolDto);

    RolDTO toDto(Rol rol);

    void updateRol(RolDTO rolDto, @MappingTarget Rol entity);

    List<RolDTO> toList(List<Rol> listaRol);
}
