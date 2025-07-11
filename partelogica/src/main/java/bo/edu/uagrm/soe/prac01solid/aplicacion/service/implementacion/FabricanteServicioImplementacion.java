package bo.edu.uagrm.soe.prac01solid.aplicacion.service.implementacion;

import java.util.List;
import org.springframework.stereotype.Service;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.FabricanteDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.FabricanteServicio;
import bo.edu.uagrm.soe.prac01solid.domain.entity.Fabricante;
import bo.edu.uagrm.soe.prac01solid.domain.repository.FabricanteRepositorio;
import bo.edu.uagrm.soe.prac01solid.exception.RecursoNoEncontradoException;

@Service
public class FabricanteServicioImplementacion implements FabricanteServicio {

    private final FabricanteRepositorio repositorio;

    public FabricanteServicioImplementacion(FabricanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<FabricanteDTO> obtenerTodos() {
        return repositorio.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    @Override
    public FabricanteDTO obtenerPorId(Long id) {
        Fabricante fabricante = repositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Fabricante no encontrado"));
        return convertirADTO(fabricante);
    }

    @Override
    public FabricanteDTO crear(FabricanteDTO dto) {
        Fabricante fabricante = convertirAEntidad(dto);
        return convertirADTO(repositorio.save(fabricante));
    }

    @Override
    public FabricanteDTO actualizar(Long id, FabricanteDTO dto) {
        Fabricante fabricante = repositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Fabricante no encontrado"));

        fabricante.setNombre(dto.getNombre());

        return convertirADTO(repositorio.save(fabricante));
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    private FabricanteDTO convertirADTO(Fabricante fabricante) {
        FabricanteDTO dto = new FabricanteDTO();
        dto.setId(fabricante.getId());
        dto.setNombre(fabricante.getNombre());
        return dto;
    }

    private Fabricante convertirAEntidad(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(dto.getNombre());
        return fabricante;
    }
}