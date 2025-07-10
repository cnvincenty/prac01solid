package bo.edu.uagrm.soe.prac01solid.api.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uagrm.soe.prac01solid.aplicacion.otd.GrupoOTD;
import bo.edu.uagrm.soe.prac01solid.aplicacion.servicio.GrupoServicio;

@RestController
@RequestMapping("/api/v1/grupo")
public class GrupoControlador {

    private final GrupoServicio servicio;

    public GrupoControlador(GrupoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<GrupoOTD> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public GrupoOTD obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public GrupoOTD crear(@RequestBody GrupoOTD dto) {
        return servicio.crear(dto);
    }

    @PutMapping("/{id}")
    public GrupoOTD actualizar(@PathVariable Long id, @RequestBody GrupoOTD dto) {
        return servicio.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
