

package ar.edu.utn.yachtclub.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class MenuEmpleadoController {

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping("/menu")
    public String menu() {
        return "menus/menu-empleado";
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping("/socios")
    public String socios() {
        return "socios/lista";
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping("/embarcaciones")
    public String embarcaciones() {
        return "embarcaciones/lista";
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping("/empleadozona/mis-zonas")
    public String misZonas() {
        return "empleadozona/mis-zonas";
    }
}