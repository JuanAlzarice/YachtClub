package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.CompraAmarre;
import ar.edu.utn.yachtclub.repository.CompraAmarreRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompraAmarreImpl implements CompraAmarreService {
    
    private final CompraAmarreRepository repo;
    
    public CompraAmarreImpl(CompraAmarreRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public List<CompraAmarre> listar() {
        return repo.findAll();
    }
    
    @Override
    public CompraAmarre guardar(CompraAmarre c) {
        return repo.save(c);
    }
    
    @Override
    public CompraAmarre buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}
