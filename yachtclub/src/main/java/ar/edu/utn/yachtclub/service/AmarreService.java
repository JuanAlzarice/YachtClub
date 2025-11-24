package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Amarre;
import java.util.List;

public interface AmarreService {

    List<Amarre> listar();

    Amarre guardar(Amarre amarre);

    Amarre buscarPorId(Long id);

    void eliminar(Long id);
}
