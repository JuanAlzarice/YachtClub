package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Rol;
import ar.edu.utn.yachtclub.entity.Usuario;
import ar.edu.utn.yachtclub.service.RolService;
import ar.edu.utn.yachtclub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/lista")
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Usuario usuario = new Usuario();
        List<Rol> roles = rolService.listar();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);
        return "usuarios/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario, @RequestParam(required = false) Long rolSeleccionado) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setEnabled(true);

        if (rolSeleccionado != null) {
            Rol rol = rolService.buscarPorId(rolSeleccionado);
            usuario.setRol(rol);
        } else {
            usuario.setRol(null);
        }

        usuarioService.guardar(usuario);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        List<Rol> roles = rolService.listar();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);
        return "usuarios/form"; // reusa el mismo formulario
    }

}
