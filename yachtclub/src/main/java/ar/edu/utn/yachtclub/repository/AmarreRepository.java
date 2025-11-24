
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Amarre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmarreRepository extends JpaRepository <Amarre, Long>{
    
}
