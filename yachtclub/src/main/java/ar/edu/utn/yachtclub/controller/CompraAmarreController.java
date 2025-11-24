
package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.CompraAmarre;
import ar.edu.utn.yachtclub.service.CompraAmarreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class CompraAmarreController {
    private final CompraAmarreService service;
    public CompraAmarreController(CompraAmarreService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", service.listar());
        return "compras/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("compra", new CompraAmarre());
        return "compras/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute CompraAmarre c) {
        service.guardar(c);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("compra", service.buscarPorId(id));
        return "compras/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/compras";
    }
}