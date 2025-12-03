
package ar.edu.utn.yachtclub.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MenuAdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/menu")
    public String menu() {
        return "menus/menu-admin";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/socios")
    public String socios() {
        return "socios/lista"; // vista de gestión de socios
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/embarcaciones")
    public String embarcaciones() {
        return "embarcaciones/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/zonas")
    public String zonas() {
        return "zonas/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/amarres")
    public String amarres() {
        return "amarres/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/empleadozona/lista")
    public String asignaciones() {
        return "empleadozona/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/empleados")
    public String empleados() {
        return "empleados/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios/lista")
    public String usuarios() {
        return "usuarios/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/compras")
    public String compras() {
        return "compras/lista";
    }
}