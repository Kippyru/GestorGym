package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Miembro;
import com.gym.GestorGym.models.Reserva;
import com.gym.GestorGym.models.Turno;
import com.gym.GestorGym.repository.MiembroRepository;
import com.gym.GestorGym.repository.TurnoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReservaMapper {
    @Autowired
    protected MiembroRepository miembroRepository;
    @Autowired
    protected TurnoRepository turnoRepository;

    @Mapping(target = "idMiembro", source = "idMiembro", qualifiedByName = "mapIdToMiembro")
    @Mapping(target = "idTurno", source = "idTurno", qualifiedByName = "mapIdToTurno")
    public abstract Reserva toEntity(ReservaDTO reservaDTO);

    @Mapping(target = "idMiembro", source = "idMiembro.id")
    @Mapping(target = "idTurno", source = "idTurno.id")
    public abstract ReservaDTO toDto(Reserva reserva);

    @Named("mapIdToMiembro")
    protected Miembro mapIdToMiembro(Integer idMiembro) {
        if (idMiembro == null) return null;
        return miembroRepository.findById(idMiembro)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
    }

    @Named("mapIdToTurno")
    protected Turno mapIdToTurno(Integer idTurno) {
        if (idTurno == null) return null;
        return turnoRepository.findById(idTurno)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }

    @Mapping(target = "idMiembro", source = "idMiembro", qualifiedByName = "mapIdToMiembro")
    @Mapping(target = "idTurno", source = "idTurno", qualifiedByName = "mapIdToTurno")
    public abstract void updateReserva(ReservaDTO reservaDTO, @MappingTarget Reserva entity);

    public abstract List<ReservaDTO> reservaList(List<Reserva> reservas);

}
