package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.CompraAmarre;
import java.util.List;

public interface CompraAmarreService {

    List<CompraAmarre> listar();

    CompraAmarre guardar(CompraAmarre c);

    CompraAmarre buscarPorId(Long id);

    void eliminar(Long id);
}
