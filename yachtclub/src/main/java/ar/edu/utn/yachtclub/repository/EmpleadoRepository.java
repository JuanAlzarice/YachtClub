
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long>  {
    Empleado findByUsuarioUsername(String username);

    
}
