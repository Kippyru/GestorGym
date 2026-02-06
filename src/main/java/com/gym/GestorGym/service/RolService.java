package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.Mapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/*
public class RolService implements IRolService {

    @Autowired
    private RolRepository repo;

    @Override
    public List<RolDTO> traerRol() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }


    public RolDTO crearRol(RolDTO rolDto) {
        Rol rol = Mapper.toEntity(rolDto);
        repo.save(rol);
        return rolDto;
    }

    @Override
    public RolDTO actualizarRol(Integer id_rol, RolDTO rolDto) {
        //existe la persona?
        Rol rol = repo.findById(id_rol)
                .orElseThrow(() -> new NotFoundException("Rol no encontrado"));
        rol.setNombre(rolDto.getNombre());
        return Mapper.toDTO(repo.save(rol));
    }

    @Override
    public void eliminarRol(Integer id_rol) {
        if (!repo.existsById(id_rol)){
            throw new NotFoundException("Rol no encontrada para eliminar");
        }

        repo.deleteById(id_rol);
    }

}
*/