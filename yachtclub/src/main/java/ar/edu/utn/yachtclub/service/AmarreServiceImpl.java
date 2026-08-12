package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Amarre;
import ar.edu.utn.yachtclub.exception.ResourceNotFoundException;
import ar.edu.utn.yachtclub.repository.AmarreRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmarreServiceImpl implements AmarreService {

    private final AmarreRepository repo;

    public AmarreServiceImpl(AmarreRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Amarre> listar() {
        return repo.findAll();
    }

    @Override
    public Amarre guardar(Amarre amarre) {
        return repo.save(amarre);
    }

    @Override
    public Amarre buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Amarre", id));
    }

    @Override
    public void eliminar(Long id) {

        Amarre amarre = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Amarre", id));

        repo.delete(amarre);
    }
}
