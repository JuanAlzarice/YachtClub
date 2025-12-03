package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Usuario;
import ar.edu.utn.yachtclub.repository.UsuarioRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping({"/", "/index"})
    public String home(Model model, Principal principal) {

        if (principal != null) {
            Usuario usuario = usuarioRepository.findByUsername(principal.getName());
            String rol = usuario.getRol().getNombre().toLowerCase(); // admin / socio / empleado

            String fragment = "menus/menu-" + rol + " :: menu-" + rol;

            model.addAttribute("menuFragment", fragment);
            model.addAttribute("usuario", usuario);
        }

        return "index";
    }
}

