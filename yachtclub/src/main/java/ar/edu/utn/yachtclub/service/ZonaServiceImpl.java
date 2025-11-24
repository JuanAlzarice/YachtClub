
package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Zona;
import ar.edu.utn.yachtclub.repository.ZonaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ZonaServiceImpl implements ZonaService {
    private final ZonaRepository repo;

    public ZonaServiceImpl(ZonaRepository repo) {
        this.repo = repo;
    }
    
    

    @Override
    public List<Zona> listar() { return repo.findAll() ; }

    @Override
    public Zona guardar(Zona z) { return repo.save(z);}

    @Override
    public Zona buscarPorId(Long id) { return repo.findById(id).orElse(null);}

    @Override
    public void eliminar(Long id) { repo.deleteById(id);}
    
}
