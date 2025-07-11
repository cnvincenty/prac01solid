package bo.edu.uagrm.soe.prac01solid.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_barra", length = 50)
    private String codBarra;

    @Column(name = "cod_alternativo", length = 50)
    private String codAlternativo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "nombre_extranjero", length = 100)
    private String nombreExtranjero;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @Column(name = "peso")
    private double peso;

    @Column(name = "unidad_medida", length = 10)
    private String unidadMedida;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;
}
