package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Socio;
import ar.edu.utn.yachtclub.entity.Usuario;
import ar.edu.utn.yachtclub.service.SocioService;
import ar.edu.utn.yachtclub.service.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/socios")
public class SocioController {

    private final SocioService service;
    private final UsuarioService usuarioService;

    public SocioController(SocioService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

   

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("socios", service.listar());
        return "socios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("socio", new Socio());
        return "socios/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Socio socio) {
        service.guardar(socio);
        return "redirect:/socios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Socio s = service.buscarPorId(id);
        model.addAttribute("socio", s);
        return "socios/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/socios";
    }

    @GetMapping("/mis-datos")
    public String misDatos(Authentication auth, Model model) {

        Usuario usuario = usuarioService.buscarPorUsername(auth.getName());

        if (usuario == null || usuario.getSocio() == null) {
            return "redirect:/?error=no_socio";
        }

        model.addAttribute("socio", usuario.getSocio());
        return "socios/mis-datos";
    }

}
