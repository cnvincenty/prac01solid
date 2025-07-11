package bo.edu.uagrm.soe.prac01solid.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.FabricanteDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.FabricanteServicio;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fabricante")
@Tag(name = "Fabricantes", description = "Gestión de fabricantes")
@CrossOrigin
public class FabricanteControlador {

    private final FabricanteServicio fabricanteServicio;

    public FabricanteControlador(FabricanteServicio fabricanteServicio) {
        this.fabricanteServicio = fabricanteServicio;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los fabricantes")
    public ResponseEntity<List<FabricanteDTO>> obtenerTodos() {
        return ResponseEntity.ok(fabricanteServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener fabricante por ID")
    public ResponseEntity<FabricanteDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fabricanteServicio.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo fabricante")
    public ResponseEntity<FabricanteDTO> crear(@RequestBody FabricanteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(fabricanteServicio.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar fabricante")
    public ResponseEntity<FabricanteDTO> actualizar(@PathVariable Long id, @RequestBody FabricanteDTO dto) {
        return ResponseEntity.ok(fabricanteServicio.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar fabricante")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        fabricanteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}