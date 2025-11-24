
package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Empleado;
import ar.edu.utn.yachtclub.service.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleados")

public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }
    
    @GetMapping
    public String listar(Model model){
       model.addAttribute("empleados", service.listar());
       return "empleados/lista";
    }
    
     @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado e) {
        service.guardar(e);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("empleado", service.buscarPorId(id));
        return "empleados/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/empleados";
    }

}
