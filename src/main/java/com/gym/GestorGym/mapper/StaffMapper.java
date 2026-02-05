package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.StaffDTO;
import com.gym.GestorGym.models.Persona;
import com.gym.GestorGym.models.Staff;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.PersonaRepository;
import com.gym.GestorGym.repository.TurnoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {
    @Autowired
    protected PersonaRepository personaRepository;
    @Autowired
    protected TurnoRepository turnoRepository;

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    @Mapping(target = "idTurno", source = "idTurno", qualifiedByName = "mapIdToTurno")
    public abstract Staff toEntity(StaffDTO staffDTO);

    @Mapping(target = "idPersona", source = "idPersona.id")
    @Mapping(target = "idTurno", source = "idTurno.id")
    public abstract StaffDTO toDto(Staff staff);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona(Integer idPersona) {
        if (idPersona == null) return null;
        return personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Named("mapIdToTurno")
    protected Turno mapIdToTurno(Integer idTurno) {
        if (idTurno == null) return null;
        return turnoRepository.findById(idTurno)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    @Mapping(target = "idTurno", source = "idTurno", qualifiedByName = "mapIdToTurno")
    public abstract void updateStaff(StaffDTO staffDTO, @MappingTarget Staff entity);

    public abstract List<StaffDTO> staffList(List<Staff> staffs);

}
