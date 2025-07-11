package bo.edu.uagrm.soe.prac01solid.aplicacion.service.implementacion;

import java.util.List;
import org.springframework.stereotype.Service;
import bo.edu.uagrm.soe.prac01solid.aplicacion.dto.ProductoDTO;
import bo.edu.uagrm.soe.prac01solid.aplicacion.service.ProductoServicio;
import bo.edu.uagrm.soe.prac01solid.domain.entity.*;
import bo.edu.uagrm.soe.prac01solid.domain.repository.*;
import bo.edu.uagrm.soe.prac01solid.exception.RecursoNoEncontradoException;

@Service
public class ProductoServicioImplementacion implements ProductoServicio {

    private final ProductoRepositorio repositorio;
    private final FabricanteRepositorio fabricanteRepositorio;
    private final ProveedorRepositorio proveedorRepositorio;
    private final GrupoRepositorio grupoRepositorio;

    public ProductoServicioImplementacion(ProductoRepositorio repositorio, 
                                        FabricanteRepositorio fabricanteRepositorio,
                                        ProveedorRepositorio proveedorRepositorio,
                                        GrupoRepositorio grupoRepositorio) {
        this.repositorio = repositorio;
        this.fabricanteRepositorio = fabricanteRepositorio;
        this.proveedorRepositorio = proveedorRepositorio;
        this.grupoRepositorio = grupoRepositorio;
    }

    @Override
    public List<ProductoDTO> obtenerTodos() {
        return repositorio.findAll().stream()
            .map(this::convertirADTO)
            .toList();
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = repositorio.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado"));
        return convertirADTO(producto);
    }

    @Override
    public ProductoDTO crear(ProductoDTO dto) {
        Producto producto = convertirAEntidad(dto);
        return convertirADTO(repositorio.save(producto));
    }

    @Override
    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = repositorio.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado"));
        
        producto.setNombre(dto.getNombre());
        producto.setNombreExtranjero(dto.getNombreExtranjero());
        producto.setCodBarra(dto.getCodBarra());
        producto.setCodAlternativo(dto.getCodAlternativo());
        producto.setPeso(dto.getPeso());
        producto.setUnidadMedida(dto.getUnidadMedida());
        producto.setPrecio(dto.getPrecio());
        
        if (dto.getFabricanteId() != null) {
            Fabricante fabricante = fabricanteRepositorio.findById(dto.getFabricanteId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Fabricante no encontrado"));
            producto.setFabricante(fabricante);
        }
        
        if (dto.getProveedorId() != null) {
            Proveedor proveedor = proveedorRepositorio.findById(dto.getProveedorId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
            producto.setProveedor(proveedor);
        }
        
        if (dto.getGrupoId() != null) {
            Grupo grupo = grupoRepositorio.findById(dto.getGrupoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Grupo no encontrado"));
            producto.setGrupo(grupo);
        }
        
        return convertirADTO(repositorio.save(producto));
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    private ProductoDTO convertirADTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setNombreExtranjero(producto.getNombreExtranjero());
        dto.setCodBarra(producto.getCodBarra());
        dto.setCodAlternativo(producto.getCodAlternativo());
        dto.setPeso(producto.getPeso());
        dto.setUnidadMedida(producto.getUnidadMedida());
        dto.setPrecio(producto.getPrecio());
        dto.setFabricanteId(producto.getFabricante() != null ? producto.getFabricante().getId() : null);
        dto.setProveedorId(producto.getProveedor() != null ? producto.getProveedor().getId() : null);
        dto.setGrupoId(producto.getGrupo() != null ? producto.getGrupo().getId() : null);
        return dto;
    }

    private Producto convertirAEntidad(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setNombreExtranjero(dto.getNombreExtranjero());
        producto.setCodBarra(dto.getCodBarra());
        producto.setCodAlternativo(dto.getCodAlternativo());
        producto.setPeso(dto.getPeso());
        producto.setUnidadMedida(dto.getUnidadMedida());
        producto.setPrecio(dto.getPrecio());
        
        if (dto.getFabricanteId() != null) {
            Fabricante fabricante = fabricanteRepositorio.findById(dto.getFabricanteId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Fabricante no encontrado"));
            producto.setFabricante(fabricante);
        }
        
        if (dto.getProveedorId() != null) {
            Proveedor proveedor = proveedorRepositorio.findById(dto.getProveedorId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
            producto.setProveedor(proveedor);
        }
        
        if (dto.getGrupoId() != null) {
            Grupo grupo = grupoRepositorio.findById(dto.getGrupoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Grupo no encontrado"));
            producto.setGrupo(grupo);
        }
        
        return producto;
    }
}