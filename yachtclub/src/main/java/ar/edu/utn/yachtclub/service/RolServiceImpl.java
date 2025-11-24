package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Rol;
import ar.edu.utn.yachtclub.repository.RolRepository;
import ar.edu.utn.yachtclub.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }
}
