package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    Rol toEntity(RolDTO rolDTO);

    RolDTO toDto(Rol rol);

    List<RolDTO> rolList(List<Rol> rols);

    void updateRol(RolDTO rolDTO, @MappingTarget Rol rol);


}
