package bo.edu.uagrm.soe.prac01solid.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.GrupoDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.GrupoServicio;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/grupo")
@CrossOrigin
public class GrupoControlador {

    private final GrupoServicio grupoServicio;

    public GrupoControlador(GrupoServicio grupoServicio) {
        this.grupoServicio = grupoServicio;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los grupos")
    public ResponseEntity<List<GrupoDTO>> obtenerTodos() {
        return ResponseEntity.ok(grupoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener grupo por ID")
    public ResponseEntity<GrupoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(grupoServicio.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo grupo")
    public ResponseEntity<GrupoDTO> crear(@RequestBody GrupoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(grupoServicio.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar grupo")
    public ResponseEntity<GrupoDTO> actualizar(@PathVariable Long id, @RequestBody GrupoDTO dto) {
        return ResponseEntity.ok(grupoServicio.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar grupo")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        grupoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
