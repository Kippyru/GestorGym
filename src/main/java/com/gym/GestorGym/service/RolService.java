package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.RolDTO;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public void crear (RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        rolRepository.save(rol);
    }

    public List<Rol> lista(){
        return rolRepository.findAll();
    }

    public Rol listaId(int id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    public void update(int id, RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        rolRepository.save(rol);
    }

    public void delete(int id){
        rolRepository.deleteById(id);
    }
}
