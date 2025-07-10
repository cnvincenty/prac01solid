package bo.edu.uagrm.soe.prac01solid.aplicacion.servicio.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.edu.uagrm.soe.prac01solid.aplicacion.mapeador.GrupoMapeador;
import bo.edu.uagrm.soe.prac01solid.aplicacion.otd.GrupoOTD;
import bo.edu.uagrm.soe.prac01solid.aplicacion.servicio.GrupoServicio;
import bo.edu.uagrm.soe.prac01solid.comun.RecursoNoEncontradoException;
import bo.edu.uagrm.soe.prac01solid.dominio.entidad.Grupo;
import bo.edu.uagrm.soe.prac01solid.ingraestructura.persistencia.GrupoRepositorio;

@Service
public class GrupoServicioImplementacion implements GrupoServicio{

    private final GrupoRepositorio repositorio;

    private final GrupoMapeador mapeador;

    public GrupoServicioImplementacion(GrupoRepositorio repositorio, GrupoMapeador mapeador) {
        this.repositorio = repositorio;
        this.mapeador = mapeador;
    }

    @Override
    public List<GrupoOTD> obtenerTodos() {
        return repositorio.findAll().stream().map(mapeador::aOtd).toList();
    }

    @Override
    public GrupoOTD obtenerPorId(Long id) {
        return mapeador.aOtd(repositorio.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No encontrado")));
    }

    @Override
    public GrupoOTD crear(GrupoOTD otd) {
        Grupo entrada = mapeador.aEntidad(otd);
        return mapeador.aOtd(repositorio.save(entrada));
    }

    @Override
    public GrupoOTD actualizar(Long id, GrupoOTD otd) {
        Grupo entrada = repositorio.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No encontrado"));
        entrada.setCodigo(otd.getCodigo());
        entrada.setGrupo(otd.getGrupo());
        return mapeador.aOtd(repositorio.save(entrada));
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

}
