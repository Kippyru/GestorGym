package com.gym.GestorGym.service;

/*
@Service
public class MiembroService implements IMiembroService{


    @Autowired
    private MiembroRepository repo;

    @Override
    public List<MiembroDTO> traerMiembro() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public MiembroDTO crearMiembro(MiembroDTO miembroDto) {
        var m = Miembro.builder()
                .estado(miembroDto.isEstado())
                .fecha_ingreso(miembroDto.getFecha_ingreso())
                .build();
        return Mapper.toDTO(repo.save(m));
    }

    @Override
    public MiembroDTO actualizarMiembro(Integer id_miembro, MiembroDTO miembroDto) {
        //existe la persona?
        Miembro m = repo.findById(id_miembro)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado"));
        m.setEstado(miembroDto.isEstado());
        m.setFecha_ingreso(miembroDto.getFecha_ingreso());

        return Mapper.toDTO(repo.save(m));
    }

    @Override
    public void eliminarMiembro(Integer id_miembro) {
        if (!repo.existsById(id_miembro)){
            throw new NotFoundException("Persona no encontrada para eliminar");
        }

        repo.deleteById(id_miembro);
    }

}
*/