package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.RolMapper;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolService implements IRolService {

    @Autowired
    private RolRepository repo;

    @Autowired
    private RolMapper rolMapper;

    //lista q almacena objetos de tipo RolDto
    //traerRol es una variable, almacena la lista
    public List<RolDTO> traerRol() {
        List<Rol> rol = repo.findAll();
        return rolMapper.toList(rol);
    }

    public RolDTO buscarId(Integer id){
        Rol rol = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Rol no encontrada"));
        return rolMapper.toDto(rol);
    }


    public RolDTO crearRol(RolDTO rolDto) {
        Rol rol = rolMapper.toEntity(rolDto);
        repo.save(rol);
        return rolDto;
    }

    public RolDTO actualizarRol(Integer id, RolDTO rolDto) {

        Rol rol = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Rol no encontrada"));
        rolMapper.updateRol(rolDto, rol);
        Rol rolU = repo.save(rol);

        return rolMapper.toDto(rolU);
    }


    public void eliminarRol(Integer id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("Rol no encontrada para eliminar");
        }
        repo.deleteById(id);
    }

}
