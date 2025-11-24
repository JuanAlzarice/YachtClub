
package ar.edu.utn.yachtclub.service;

import ar.edu.utn.yachtclub.entity.Socio;
import ar.edu.utn.yachtclub.repository.SocioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SocioServiceImpl implements SocioService {
      private final SocioRepository repo;

    public SocioServiceImpl(SocioRepository repo) {
        this.repo = repo;
    }

    @Override public List<Socio> listar() { return repo.findAll(); }
    @Override public Socio guardar(Socio s){ return repo.save(s); }
    @Override public Socio buscarPorId(Long id){ return repo.findById(id).orElse(null); }
    @Override public void eliminar(Long id){ repo.deleteById(id); }
}
