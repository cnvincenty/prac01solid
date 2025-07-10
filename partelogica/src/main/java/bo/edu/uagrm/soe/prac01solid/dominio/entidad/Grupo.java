package bo.edu.uagrm.soe.prac01solid.dominio.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grupo")
@Getter
@Setter
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String grupo;

    public Grupo() {};

    public Grupo(String codigo, String grupo) {
        this.codigo = codigo;
        this.grupo = grupo;
    }
}
