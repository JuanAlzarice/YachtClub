package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Embarcacion;
import ar.edu.utn.yachtclub.exception.DuplicateResourceException;
import ar.edu.utn.yachtclub.exception.ResourceNotFoundException;
import ar.edu.utn.yachtclub.repository.EmbarcacionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmbarcacionServiceImpl implements EmbarcacionService {

    private final EmbarcacionRepository repo;

    public EmbarcacionServiceImpl(EmbarcacionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Embarcacion> listarPorSocio(Long idSocio) {
        return repo.findBySocio_Id(idSocio);
    }

    @Override
    public List<Embarcacion> listar() {
        return repo.findAll();
    }

    @Override
    public Embarcacion guardar(Embarcacion e) {

        if (repo.existsByMatricula(e.getMatricula())) {

            throw new DuplicateResourceException("Ya existe una embarcación con matrícula " + e.getMatricula());
        }

        return repo.save(e);
    }

    @Override
    public Embarcacion buscarPorId(Long id) {

        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Embarcación", id));
    }

    @Override
    public void eliminar(Long id) {

        Embarcacion embarcacion = repo.findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Embarcación", id));

        repo.delete(embarcacion);
    }

    @Override
    public boolean existeMatricula(String matricula) {
        return repo.existsByMatricula(matricula);
    }

}
