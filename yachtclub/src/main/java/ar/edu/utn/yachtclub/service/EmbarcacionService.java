package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Embarcacion;
import java.util.List;

public interface EmbarcacionService {

    List<Embarcacion> listar();

    public List<Embarcacion> listarPorSocio(Long idSocio);

    Embarcacion guardar(Embarcacion e);

    Embarcacion buscarPorId(Long id);

    void eliminar(Long id);
    public boolean existeMatricula(String matricula);

}
