package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {

}
