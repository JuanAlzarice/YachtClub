
package ar.edu.utn.yachtclub.repository;

import ar.edu.utn.yachtclub.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   boolean existsByUsername(String username);
   Usuario findByUsername(String username);
    //Optional<Usuario> findByUsername(String username); // uso el opcional para aplicar en CustomUserDetailsService por que usuario no tiene el .orElseUsername
}
