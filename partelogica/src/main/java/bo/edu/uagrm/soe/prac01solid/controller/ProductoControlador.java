package bo.edu.uagrm.soe.prac01solid.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProductoDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.ProductoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Gestión de productos")
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() {
        return ResponseEntity.ok(productoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoServicio.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto")
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoServicio.crear(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(productoServicio.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}