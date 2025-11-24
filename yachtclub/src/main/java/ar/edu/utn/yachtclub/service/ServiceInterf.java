package ar.edu.utn.yachtclub.service;

import java.util.List;

public interface ServiceInterf<Obj> {

    List<Obj> listar();

    Obj guardar(Obj o);

    Obj buscarPorId(Long id);

    void eliminar(Long id);

    Obj buscarPorUsername(String username);
}
