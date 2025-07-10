package bo.edu.uagrm.soe.prac01solid.aplicacion.mapeador;

import org.springframework.stereotype.Component;

import bo.edu.uagrm.soe.prac01solid.aplicacion.otd.GrupoOTD;
import bo.edu.uagrm.soe.prac01solid.dominio.entidad.Grupo;

@Component
public class GrupoMapeador {

    public GrupoOTD aOtd(Grupo entidad) {
        GrupoOTD otd = new GrupoOTD();
        otd.setId(entidad.getId());
        otd.setCodigo(entidad.getCodigo());
        otd.setNombre(entidad.getNombre());
        return otd;
    }

    public Grupo aEntidad(GrupoOTD otd) {
        Grupo entidad = new Grupo();
        entidad.setId(otd.getId());
        entidad.setCodigo(otd.getCodigo());
        entidad.setNombre(otd.getNombre());
        return entidad;
    }
}