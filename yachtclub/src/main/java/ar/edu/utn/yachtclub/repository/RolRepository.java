
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}
