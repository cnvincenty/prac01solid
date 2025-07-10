package bo.edu.uagrm.soe.prac01solid.dominio.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoAlternativo;

    private String codigoBarra;

    private String nombre;
    private String nombreExtranjero;

    @ManyToOne(cascade = CascadeType.ALL)
    private Grupo grupo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fabricante fabricante;

    @ManyToOne(cascade = CascadeType.ALL)
    private Proveedor proveedor;

    private double peso;
    private String unidadMedida;

    @OneToOne(cascade = CascadeType.ALL)
    private Precio precio;
}
