

package ar.edu.utn.yachtclub.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socio")
public class MenuSocioController {

    @PreAuthorize("hasRole('SOCIO')")
    @GetMapping("/menu")
    public String menu() {
        return "menus/menu-socio";
    }

    @PreAuthorize("hasRole('SOCIO')")
    @GetMapping("/mis-datos")
    public String misDatos() {
        return "socios/mis-datos";
    }

    @PreAuthorize("hasRole('SOCIO')")
    @GetMapping("/embarcaciones/mias")
    public String misEmbarcaciones() {
        return "embarcaciones/mias";
    }
}