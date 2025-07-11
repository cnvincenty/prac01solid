package bo.edu.uagrm.soe.prac01solid.aplicacion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String nombreExtranjero;
    private String codBarra;
    private String codAlternativo;
    private double peso;
    private String unidadMedida;
    private BigDecimal precio;
    private Long fabricanteId;
    private Long proveedorId;
    private Long grupoId;
}