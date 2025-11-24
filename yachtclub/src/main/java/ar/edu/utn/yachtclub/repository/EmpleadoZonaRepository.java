package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.EmpleadoZona;
import ar.edu.utn.yachtclub.entity.EmpleadoZonaId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpleadoZonaRepository extends JpaRepository<EmpleadoZona, EmpleadoZonaId> {

    List<EmpleadoZona> findByEmpleado_IdEmpleado(Long idEmpleado); // nombre exacto según entidad
}
