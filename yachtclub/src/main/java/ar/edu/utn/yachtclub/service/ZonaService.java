
package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Zona;
import java.util.List;


public interface ZonaService {
    List<Zona> listar();
    Zona guardar (Zona z);
    Zona buscarPorId(Long id);
    void eliminar (Long id);
}
