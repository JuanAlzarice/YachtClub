
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.CompraAmarre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompraAmarreRepository extends JpaRepository <CompraAmarre, Long> {
    
}
