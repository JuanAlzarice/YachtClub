
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Embarcacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbarcacionRepository extends JpaRepository<Embarcacion, Long> {
    List<Embarcacion> findBySocio_Id(Long idSocio);
    boolean existsByMatricula(String matricula);


}
