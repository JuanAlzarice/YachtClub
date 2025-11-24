package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.EmpleadoZona;
import java.util.List;

public interface EmpleadoZonaService {

    List<EmpleadoZona> listar();

    List<EmpleadoZona> findByEmpleado(Long idEmpleado);

    EmpleadoZona guardar(EmpleadoZona ez);

    void eliminar(Long idEmpleado, Long idZona);

    EmpleadoZona buscar(Long idEmpleado, Long idZona);
}
