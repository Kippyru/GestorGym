package com.gym.GestorGym.service;

import com.gym.GestorGym.dto.PagoDTO;
import com.gym.GestorGym.mapper.PagoMapper;
import com.gym.GestorGym.models.Pago;
import com.gym.GestorGym.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private PagoMapper pagoMapper;

    public void crear(PagoDTO pagoDTO) {
        Pago pago = pagoMapper.toEntity(pagoDTO);
        pagoRepository.save(pago);
    }

    public List<PagoDTO> lista() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagoMapper.pagoList(pagos);
    }

    public PagoDTO listaIdDto(int id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return pagoMapper.toDto(pago);
    }

    public PagoDTO actualizar(Integer id, PagoDTO pagoDTO) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        pagoMapper.updatePago(pagoDTO, pago);

        Pago actualizada = pagoRepository.save(pago);
        return pagoMapper.toDto(actualizada);
    }

    public void eliminar(Integer id) {
        if (!pagoRepository.existsById(id)) {
            throw new RuntimeException("Pago no encontrado");
        }
        pagoRepository.deleteById(id);
    }
}
