
package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Empleado;
import ar.edu.utn.yachtclub.entity.EmpleadoZona;
import ar.edu.utn.yachtclub.entity.Usuario;
import ar.edu.utn.yachtclub.entity.Zona;
import ar.edu.utn.yachtclub.service.UsuarioService;
import ar.edu.utn.yachtclub.service.ZonaService;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/zonas")
public class ZonaController {
    
    private final ZonaService service;
    private final UsuarioService usuarioService;

    public ZonaController(ZonaService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

 
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("zonas", service.listar());
        return "zonas/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("zona", new Zona());
        return "zonas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Zona z) {
        service.guardar(z);
        return "redirect:/zonas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("zona", service.buscarPorId(id));
        return "zonas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/zonas";
    }
    
    @GetMapping("/mia")
public String miZona(Authentication auth, Model model) {

    // Obtener usuario logueado
    String username = auth.getName();
    Usuario usuario = usuarioService.buscarPorUsername(username);

    if (usuario == null || usuario.getRol() == null 
        || !usuario.getRol().getNombre().equalsIgnoreCase("EMPLEADO")) {

        return "redirect:/?error=sin_permiso";
    }

    // El empleado
    Empleado empleado = usuario.getEmpleado(); // ← NECESITAMOS confirmar si tu Usuario tiene empleado.

    if (empleado == null) {
        return "redirect:/?error=no_empleado";
    }

    // Busca la primera zona asignada (si tiene más, mostramos todas)
    List<EmpleadoZona> zonas = empleado.getEmpleadoZonas();

    model.addAttribute("zonasAsignadas", zonas);

    return "zonas/mia";
}

    
}
