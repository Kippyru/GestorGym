package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.ClaseDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.ClaseMapper;
import com.gym.GestorGym.models.Clase;
import com.gym.GestorGym.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService implements IClaseService {

    @Autowired
    private ClaseRepository repo;

    @Autowired
    private ClaseMapper claseMapper;

    public List<ClaseDTO> traerClase() {
        List<Clase>listaClase = repo.findAll();
        return claseMapper.toList(listaClase);
    }

    public ClaseDTO buscarId(Integer id){
        Clase cla = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("no encontrada"));
        return claseMapper.toDto(cla);
    }



    public ClaseDTO crearClase(ClaseDTO claseDto) {
        Clase cla = claseMapper.toEntity(claseDto);
        repo.save(cla);
        return claseDto;
    }

    public ClaseDTO actualizarClase(Integer id, ClaseDTO claseDto) {

        Clase cla = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("no encontrada"));
        claseMapper.updateClase(claseDto, cla);
        Clase claU = repo.save(cla);

        return claseMapper.toDto(claU);
    }

    public void eliminarClase(Integer id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("no encontrada para eliminar");
        }

        repo.deleteById(id);
    }

}
