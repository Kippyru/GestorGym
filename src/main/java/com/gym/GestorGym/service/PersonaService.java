package com.gym.GestorGym.service;


import com.gym.GestorGym.dto.PersonaDTO;
import com.gym.GestorGym.exception.NotFoundException;
import com.gym.GestorGym.mapper.Mapper;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Rol;
import com.gym.GestorGym.repository.PersonaRepository;
import com.gym.GestorGym.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repo;

    @Override
    public List<PersonaDTO> traerPersonas() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDto) {
        // 1. Usamos el Mapper para pasar de DTO a Entidad
        Persona per = Mapper.toEntity(personaDto);

        // 2. Buscamos el rol y lo asignamos
        if (personaDto.getId_rol() != null) {
            Rol rol = rolRepo.findById(personaDto.getId_rol())
                    .orElseThrow(() -> new NotFoundException("El Rol con ID " + personaDto.getId_rol() + " no existe"));
            per.setRol(rol);
        }

        // 3. Guardamos y devolvemos mapeado a DTO
        return Mapper.toDTO(repo.save(per));
    }
    @Autowired
    private RolRepository rolRepo;
    @Override
    public PersonaDTO actualizarPersona(Integer id_persona, PersonaDTO personaDto) {
        //existe la persona?
        Persona per = repo.findById(id_persona)
        .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        per.setNombre(personaDto.getNombre());
        per.setApellido(personaDto.getApellido());
        per.setEmail(personaDto.getEmail());
        per.setContraseña(personaDto.getContraseña());
        System.out.println("antes del if -------------------------");
        if (personaDto.getId_rol() != null) {
            Rol rol = rolRepo.findById(personaDto.getId_rol())
                    .orElseThrow(() -> new NotFoundException("Rol no encontrado"));
            System.out.println("------------------------------------------------");
            System.out.println("Rol encontrado" + rol.getNombre() + rol.getId_rol());
            System.out.println("----------------------------------------------------------------");
            per.setRol(rol);
        }

        return Mapper.toDTO(repo.save(per));
    }

    @Override
    public void eliminarPersona(Integer id_persona) {
        if (!repo.existsById(id_persona)){
            throw new NotFoundException("Persona no encontrada para eliminar");
        }

        repo.deleteById(id_persona);
    }
}
