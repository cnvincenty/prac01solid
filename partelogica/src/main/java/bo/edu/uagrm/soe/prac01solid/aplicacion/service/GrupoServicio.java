package bo.edu.uagrm.soe.prac01solid.aplicacion.service;

import java.util.List;

import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.GrupoDTO;

public interface GrupoServicio {
    List<GrupoDTO> obtenerTodos();
    GrupoDTO obtenerPorId(Long id);
    GrupoDTO crear(GrupoDTO otd);
    GrupoDTO actualizar(Long id, GrupoDTO otd);
    void eliminar(Long id);
}
