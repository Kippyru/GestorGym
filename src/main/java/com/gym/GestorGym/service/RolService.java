package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.mapper.RolMapper;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RolMapper rolMapper;

    public void crear (RolDTO rolDTO) {
        Rol rol = rolMapper.toEntity(rolDTO);
        rolRepository.save(rol);
    }

    public List<RolDTO> lista(){
        List<Rol> rols = rolRepository.findAll();
        return rolMapper.rolList(rols);
    }

    public RolDTO listaId(int id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return rolMapper.toDto(rol);
    }

    public RolDTO update(int id, RolDTO rolDTO) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolMapper.updateRol(rolDTO, rol);
        Rol actualizado = rolRepository.save(rol);
        return rolMapper.toDto(actualizado);
    }

    public void delete(int id){
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol no encontrado");
        }
        rolRepository.deleteById(id);
    }
}
