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

    @Mapping(target = "id_persona", source = "id_persona", qualifiedByName = "mapIdToPersona")
    @Mapping(target = "id_turno", source = "id_turno", qualifiedByName = "mapIdToTurno")
    public abstract Staff toEntity (StaffDTO staffDTO);

    @Mapping(target = "id_persona", source = "id_persona.id_persona")
    @Mapping(target = "id_turno", source = "id_turno.id")
        public abstract StaffDTO toDto (Staff staff);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona (Integer id_persona){
        if (id_persona == null) return null;
        return personaRepository.findById(id_persona)
                .orElseThrow(()->new RuntimeException("Persona no encontrado"));
    }

    @Named("mapIdToTurno")
    protected Turno mapIdToTurno (Integer id_turno){
        if (id_turno == null) return null;
        return turnoRepository.findById(id_turno)
                .orElseThrow(()->new RuntimeException("Turno no encontrado"));
    }

    @Mapping(target = "id_persona", source = "id_persona", qualifiedByName = "mapIdToPersona")
    @Mapping(target = "id_turno", source = "id_turno", qualifiedByName = "mapIdToTurno")
    public abstract void updateStaff (StaffDTO staffDTO, @MappingTarget Staff entity);

    public abstract List<StaffDTO> toList (List<Staff>listaStaff);

}
