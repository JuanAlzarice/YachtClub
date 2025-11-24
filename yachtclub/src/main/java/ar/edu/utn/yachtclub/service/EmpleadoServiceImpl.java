package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Empleado;
import ar.edu.utn.yachtclub.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository repo;

    public EmpleadoServiceImpl(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public Empleado obtenerEmpleadoPorUsername(String username) {
        return repo.findByUsuarioUsername(username);
    }

    @Override
    public List<Empleado> listar() {
        return repo.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return repo.save(empleado);
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Empleado buscarPorUsuario(String username) {
        return repo.findByUsuarioUsername(username);
    }
    
    

}
