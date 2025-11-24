
package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Empleado;
import java.util.List;

public interface EmpleadoService {

    List<Empleado> listar();

    Empleado guardar(Empleado empleado);

    Empleado buscarPorId(Long id);

    void eliminar(Long id);

    public Empleado buscarPorUsuario(String username);
}
