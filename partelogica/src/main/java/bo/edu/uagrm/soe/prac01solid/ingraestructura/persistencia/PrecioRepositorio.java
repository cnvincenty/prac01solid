package bo.edu.uagrm.soe.prac01solid.ingraestructura.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.edu.uagrm.soe.prac01solid.dominio.entidad.Precio;

@Repository
public interface PrecioRepositorio extends JpaRepository<Precio, Long>{

}
