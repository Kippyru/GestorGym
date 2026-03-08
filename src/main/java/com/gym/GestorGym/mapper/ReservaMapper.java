package com.gym.GestorGym.mapper;

import com.gym.GestorGym.dto.ReservaDTO;
import com.gym.GestorGym.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    Reserva toEntity (ReservaDTO reservaDTO);

    ReservaDTO toDto (Reserva reserva);

    void updateReserva (ReservaDTO reservaDTO, @MappingTarget Reserva entity);

    List<ReservaDTO> toList (List<Reserva>listaReserva);

}
