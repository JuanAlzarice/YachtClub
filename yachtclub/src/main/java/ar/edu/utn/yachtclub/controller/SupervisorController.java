package ar.edu.utn.yachtclub.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

  
    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/menu")
    public String menu() {
        return "menus/menu-supervisor";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/socios")
    public String socios() {
        return "socios/lista"; // vista de gestión de socios
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/embarcaciones")
    public String embarcaciones() {
        return "embarcaciones/lista";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/zonas")
    public String zonas() {
        return "zonas/lista";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/amarres")
    public String amarres() {
        return "amarres/lista";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/empleadozona/lista")
    public String asignaciones() {
        return "empleadozona/lista";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/empleados")
    public String empleados() {
        return "empleados/lista";
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @GetMapping("/compras")
    public String compras() {
        return "compras/lista";
    }
}