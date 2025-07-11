package bo.edu.uagrm.soe.prac01solid.aplicacion.service.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.GrupoDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.mappers.GrupoMapeador;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.GrupoServicio;
import bo.edu.uagrm.soe.prac01solid.domain.entity.Grupo;
import bo.edu.uagrm.soe.prac01solid.domain.repository.GrupoRepositorio;
import bo.edu.uagrm.soe.prac01solid.exception.RecursoNoEncontradoException;

@Service
public class GrupoServicioImplementacion implements GrupoServicio {

    private final GrupoRepositorio repositorio;

    private final GrupoMapeador mapeador;

    public GrupoServicioImplementacion(GrupoRepositorio repositorio, GrupoMapeador mapeador) {
        this.repositorio = repositorio;
        this.mapeador = mapeador;
    }

    @Override
    public List<GrupoDTO> obtenerTodos() {
        return repositorio.findAll().stream().map(mapeador::aOtd).toList();
    }

    @Override
    public GrupoDTO obtenerPorId(Long id) {
        return mapeador
                .aOtd(repositorio.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No encontrado")));
    }

    @Override
    public GrupoDTO crear(GrupoDTO otd) {
        Grupo entrada = mapeador.aEntidad(otd);
        return mapeador.aOtd(repositorio.save(entrada));
    }

    @Override
    public GrupoDTO actualizar(Long id, GrupoDTO otd) {
        Grupo entrada = repositorio.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No encontrado"));
        entrada.setCodigo(otd.getCodigo());
        entrada.setNombre(otd.getNombre());
        return mapeador.aOtd(repositorio.save(entrada));
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

}
