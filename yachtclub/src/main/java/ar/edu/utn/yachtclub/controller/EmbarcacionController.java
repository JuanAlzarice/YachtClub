package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Embarcacion;
import ar.edu.utn.yachtclub.entity.Usuario;
import ar.edu.utn.yachtclub.service.EmbarcacionService;
import ar.edu.utn.yachtclub.service.SocioService;
import ar.edu.utn.yachtclub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/embarcaciones")
public class EmbarcacionController {

    @Autowired
    private EmbarcacionService embarcacionService;

    @Autowired
    private SocioService socioService;

    @Autowired
    private UsuarioService usuarioService;

    // LISTAR EMBARCACIONES POR ROL
    @GetMapping
    public String listarPrincipal(Model model, Authentication authentication) {
        return listar(model, authentication);  // reutiliza el método existente
    }

    //  Listar embarcaciones según el rol
    @GetMapping("/todas")
    public String listar(Model model, Authentication authentication) {
        String username = authentication.getName();
        Usuario usuario = usuarioService.buscarPorUsername(username);

        List<Embarcacion> embarcaciones;

        if (usuario != null && usuario.getRol() != null && "SOCIO".equalsIgnoreCase(usuario.getRol().getNombre())) {
            // Si es SOCIO, solo sus embarcaciones
            embarcaciones = embarcacionService.listarPorSocio(usuario.getSocio().getIdSocio());
        } else {
            // ADMIN y EMPLEADOS ven todas
            embarcaciones = embarcacionService.listar();
        }

        model.addAttribute("embarcaciones", embarcaciones);
        return "embarcaciones/lista";
    }

    // Mostrar las embarcaciones de cada socio
    @GetMapping("/mias")
    public String misEmbarcaciones(Authentication auth, Model model) {

        Usuario usuario = usuarioService.buscarPorUsername(auth.getName());

        if (usuario == null || usuario.getSocio() == null) {
            return "redirect:/?error=no_socio";
        }

        Long idSocio = usuario.getSocio().getIdSocio();

        List<Embarcacion> embarcaciones = embarcacionService.listarPorSocio(idSocio);

        model.addAttribute("embarcaciones", embarcaciones);

        return "embarcaciones/lista";  // usa la misma vista
    }

    // 🆕 Mostrar formulario de alta
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("embarcacion", new Embarcacion());
        model.addAttribute("socios", socioService.listar());
        return "embarcaciones/form";
    }

    // 💾 Guardar embarcación
    ////    @PostMapping("/guardar")
////    public String guardar(@ModelAttribute Embarcacion embarcacion) {
////        embarcacionService.guardar(embarcacion);
////        return "redirect:/embarcaciones";
    ////    }
  
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Embarcacion embarcacion, Model model) {

        // Si es una nueva embarcación o cambió la matrícula
        boolean esNueva = (embarcacion.getIdEmbarcacion() == null);

        if (esNueva) {
            if (embarcacionService.existeMatricula(embarcacion.getMatricula())) {
                model.addAttribute("errorMatricula", "⚠️ La matrícula ya existe. Elegí otra.");
                model.addAttribute("socios", socioService.listar());
                return "embarcaciones/form";
            }
        } else {
            // Validar solo si el usuario la está cambiando
            Embarcacion actual = embarcacionService.buscarPorId(embarcacion.getIdEmbarcacion());
            if (!actual.getMatricula().equalsIgnoreCase(embarcacion.getMatricula())
                    && embarcacionService.existeMatricula(embarcacion.getMatricula())) {

                model.addAttribute("errorMatricula", "⚠️ La matrícula ya está registrada por otra embarcación.");
                model.addAttribute("socios", socioService.listar());
                return "embarcaciones/form";
            }
        }

        embarcacionService.guardar(embarcacion);
        return "redirect:/embarcaciones";
    }

    // ✏️ Editar embarcación
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Embarcacion embarcacion = embarcacionService.buscarPorId(id);
        model.addAttribute("embarcacion", embarcacion);
        model.addAttribute("socios", socioService.listar());
        return "embarcaciones/form";
    }

    // ❌ Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        embarcacionService.eliminar(id);
        return "redirect:/embarcaciones";
    }
}
