package bo.edu.uagrm.soe.prac01solid.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProveedorDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.ProveedorServicio;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedor")
@Tag(name = "Proveedores", description = "Gestión de proveedores")
@CrossOrigin
public class ProveedorControlador {

    private final ProveedorServicio proveedorServicio;

    public ProveedorControlador(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los proveedores")
    public ResponseEntity<List<ProveedorDTO>> obtenerTodos() {
        return ResponseEntity.ok(proveedorServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener proveedor por ID")
    public ResponseEntity<ProveedorDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorServicio.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo proveedor")
    public ResponseEntity<ProveedorDTO> crear(@RequestBody ProveedorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proveedorServicio.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar proveedor")
    public ResponseEntity<ProveedorDTO> actualizar(@PathVariable Long id, @RequestBody ProveedorDTO dto) {
        return ResponseEntity.ok(proveedorServicio.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar proveedor")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        proveedorServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}