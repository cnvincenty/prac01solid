package bo.edu.uagrm.soe.prac01solid.aplicacion.mappers;

import org.springframework.stereotype.Component;

import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.GrupoDTO;
import bo.edu.uagrm.soe.prac01solid.domain.entity.Grupo;

@Component
public class GrupoMapeador {

    public GrupoDTO aOtd(Grupo entidad) {
        GrupoDTO otd = new GrupoDTO();
        otd.setId(entidad.getId());
        otd.setCodigo(entidad.getCodigo());
        otd.setNombre(entidad.getNombre());
        return otd;
    }

    public Grupo aEntidad(GrupoDTO otd) {
        Grupo entidad = new Grupo();
        entidad.setId(otd.getId());
        entidad.setCodigo(otd.getCodigo());
        entidad.setNombre(otd.getNombre());
        return entidad;
    }
}