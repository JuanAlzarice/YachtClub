package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    void eliminar(Long id);

    Usuario buscarPorUsername(String username);
}
