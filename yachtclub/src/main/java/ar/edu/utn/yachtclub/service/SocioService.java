
package ar.edu.utn.yachtclub.service;
import ar.edu.utn.yachtclub.entity.Socio;
import java.util.List;

public interface SocioService {
    List<Socio> listar();
    Socio guardar(Socio socio);
    Socio buscarPorId(Long id);
    void eliminar(Long id);
}
