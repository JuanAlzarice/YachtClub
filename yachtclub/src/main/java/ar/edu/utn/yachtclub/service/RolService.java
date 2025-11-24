package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listar();
    Rol guardar(Rol rol);
    Rol buscarPorId(Long id);
}
