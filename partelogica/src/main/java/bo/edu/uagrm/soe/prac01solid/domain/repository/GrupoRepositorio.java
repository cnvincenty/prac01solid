package bo.edu.uagrm.soe.prac01solid.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.edu.uagrm.soe.prac01solid.domain.entity.Grupo;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, Long>{

}
