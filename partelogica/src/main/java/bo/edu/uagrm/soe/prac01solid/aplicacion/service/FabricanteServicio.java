package bo.edu.uagrm.soe.prac01solid.aplicacion.service;

import java.util.List;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.FabricanteDTO;

public interface FabricanteServicio {
    List<FabricanteDTO> obtenerTodos();

    FabricanteDTO obtenerPorId(Long id);

    FabricanteDTO crear(FabricanteDTO dto);

    FabricanteDTO actualizar(Long id, FabricanteDTO dto);

    void eliminar(Long id);
}