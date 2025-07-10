package bo.edu.uagrm.soe.prac01solid.aplicacion.servicio;

import java.util.List;

import bo.edu.uagrm.soe.prac01solid.aplicacion.otd.GrupoOTD;

public interface GrupoServicio {

    List<GrupoOTD> obtenerTodos();

    GrupoOTD obtenerPorId(Long id);

    GrupoOTD crear(GrupoOTD otd);

    GrupoOTD actualizar(Long id, GrupoOTD otd);

    void eliminar(Long id);

}
