package bo.edu.uagrm.soe.prac01solid.aplicacion.service;

import java.util.List;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProveedorDTO;

public interface ProveedorServicio {
    List<ProveedorDTO> obtenerTodos();
    ProveedorDTO obtenerPorId(Long id);
    ProveedorDTO crear(ProveedorDTO dto);
    ProveedorDTO actualizar(Long id, ProveedorDTO dto);
    void eliminar(Long id);
}