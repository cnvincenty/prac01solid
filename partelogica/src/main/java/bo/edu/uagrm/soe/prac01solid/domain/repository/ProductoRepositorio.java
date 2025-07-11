package bo.edu.uagrm.soe.prac01solid.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.edu.uagrm.soe.prac01solid.domain.entity.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
