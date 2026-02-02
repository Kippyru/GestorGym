package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public void crear (RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        rolRepository.save(rol);
    }
}
