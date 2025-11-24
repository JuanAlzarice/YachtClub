package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Amarre;
import ar.edu.utn.yachtclub.service.AmarreService;
import ar.edu.utn.yachtclub.service.ZonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/amarres")
public class AmarreController {

    private final AmarreService service;
    private final ZonaService zonaService;

    public AmarreController(AmarreService service, ZonaService zonaService) {
        this.service = service;
        this.zonaService = zonaService;
    }

    

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("amarres", service.listar());
        return "amarres/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("amarre", new Amarre());
        model.addAttribute("zonas", zonaService.listar());
        return "amarres/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Amarre a) {
        service.guardar(a);
        return "redirect:/amarres";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("amarre", service.buscarPorId(id));
        model.addAttribute("zonas", zonaService.listar());
        return "amarres/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/amarres";
    }
}
