package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.EmpleadoZona;
import ar.edu.utn.yachtclub.entity.EmpleadoZonaId;
import ar.edu.utn.yachtclub.repository.EmpleadoZonaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoZonaServiceImpl implements EmpleadoZonaService {

    private final EmpleadoZonaRepository repo;

    public EmpleadoZonaServiceImpl(EmpleadoZonaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<EmpleadoZona> listar() {
        return repo.findAll();
    }

    @Override
    public EmpleadoZona guardar(EmpleadoZona ez) {
        return repo.save(ez);
    }

    @Override
    public void eliminar(Long empleadoId, Long zonaId) {
        repo.deleteById(new EmpleadoZonaId(empleadoId, zonaId));
    }

    @Override
    public EmpleadoZona buscar(Long idEmpleado, Long idZona) {
        return repo.findById(new EmpleadoZonaId(idEmpleado, idZona)).orElse(null);
    }

    @Override
    public List<EmpleadoZona> findByEmpleado(Long idEmpleado) {
        return repo.findByEmpleado_IdEmpleado(idEmpleado);
    }
}
