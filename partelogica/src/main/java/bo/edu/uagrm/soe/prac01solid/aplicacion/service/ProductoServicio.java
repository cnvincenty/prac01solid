package bo.edu.uagrm.soe.prac01solid.aplicacion.service;

import java.util.List;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProductoDTO;

public interface ProductoServicio {
    List<ProductoDTO> obtenerTodos();
    ProductoDTO obtenerPorId(Long id);
    ProductoDTO crear(ProductoDTO dto);
    ProductoDTO actualizar(Long id, ProductoDTO dto);
    void eliminar(Long id);
}