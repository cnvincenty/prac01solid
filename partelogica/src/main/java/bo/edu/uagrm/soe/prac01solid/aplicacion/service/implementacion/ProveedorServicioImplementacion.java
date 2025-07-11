package bo.edu.uagrm.soe.prac01solid.aplicacion.service.implementacion;

import java.util.List;
import org.springframework.stereotype.Service;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProveedorDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.ProveedorServicio;
import bo.edu.uagrm.soe.prac01solid.domain.entity.Proveedor;
import bo.edu.uagrm.soe.prac01solid.domain.repository.ProveedorRepositorio;
import bo.edu.uagrm.soe.prac01solid.exception.RecursoNoEncontradoException;

@Service
public class ProveedorServicioImplementacion implements ProveedorServicio {

    private final ProveedorRepositorio repositorio;

    public ProveedorServicioImplementacion(ProveedorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<ProveedorDTO> obtenerTodos() {
        return repositorio.findAll().stream()
            .map(this::convertirADTO)
            .toList();
    }

    @Override
    public ProveedorDTO obtenerPorId(Long id) {
        Proveedor proveedor = repositorio.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
        return convertirADTO(proveedor);
    }

    @Override
    public ProveedorDTO crear(ProveedorDTO dto) {
        Proveedor proveedor = convertirAEntidad(dto);
        return convertirADTO(repositorio.save(proveedor));
    }

    @Override
    public ProveedorDTO actualizar(Long id, ProveedorDTO dto) {
        Proveedor proveedor = repositorio.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
        
        proveedor.setNombre(dto.getNombre());
        
        return convertirADTO(repositorio.save(proveedor));
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    private ProveedorDTO convertirADTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(proveedor.getId());
        dto.setNombre(proveedor.getNombre());
        return dto;
    }

    private Proveedor convertirAEntidad(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombre());
        return proveedor;
    }
}