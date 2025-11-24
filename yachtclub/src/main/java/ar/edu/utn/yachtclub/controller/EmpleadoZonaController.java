package ar.edu.utn.yachtclub.controller;

import ar.edu.utn.yachtclub.entity.Empleado;
import ar.edu.utn.yachtclub.entity.EmpleadoZona;
import ar.edu.utn.yachtclub.entity.EmpleadoZonaId;
import ar.edu.utn.yachtclub.entity.Zona;
import ar.edu.utn.yachtclub.service.EmpleadoService;
import ar.edu.utn.yachtclub.service.EmpleadoZonaService;
import ar.edu.utn.yachtclub.service.ZonaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleadozona")
public class EmpleadoZonaController {

    @Autowired
    private EmpleadoZonaService empleadoZonaService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ZonaService zonaService;

    // ***************** ADMIN **********************
    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("asignaciones", empleadoZonaService.listar());
        return "empleadozona/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleadoZona(Model model) {
        EmpleadoZona ez = new EmpleadoZona();
        List<Empleado> empleados = empleadoService.listar();
        List<Zona> zonas = zonaService.listar();
        model.addAttribute("empleadozona", ez);
        model.addAttribute("empleados", empleados);
        model.addAttribute("zonas", zonas);
        return "empleadozona/form";
    }

    @PostMapping("/guardar")
    public String guardar(
            @RequestParam Long empleadoId,
            @RequestParam Long zonaId,
            @RequestParam(required = false) Integer barcosACargo) {

        Empleado empleado = empleadoService.buscarPorId(empleadoId);
        Zona zona = zonaService.buscarPorId(zonaId);

        if (empleado == null || zona == null) {
            return "redirect:/empleadozona/nuevo?error=EmpleadoOZonaInvalido";
        }

        EmpleadoZona ez = new EmpleadoZona();
        EmpleadoZonaId id = new EmpleadoZonaId(empleado.getIdEmpleado(), zona.getIdZona());
        ez.setId(id);
        ez.setEmpleado(empleado);
        ez.setZona(zona);
        ez.setBarcosACargo(barcosACargo != null ? barcosACargo : 0);

        empleadoZonaService.guardar(ez);
        return "redirect:/empleadozona/lista";
    }

    @GetMapping("/editar/{idEmpleado}/{idZona}")
    public String editar(@PathVariable Long idEmpleado,
            @PathVariable Long idZona,
            Model model) {

        model.addAttribute("empleadozona",
                empleadoZonaService.buscar(idEmpleado, idZona));

        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("zonas", zonaService.listar());

        return "empleadozona/editar";
    }

    @GetMapping("/eliminar/{idEmpleado}/{idZona}")
    public String eliminar(@PathVariable Long idEmpleado,
            @PathVariable Long idZona) {

        empleadoZonaService.eliminar(idEmpleado, idZona);
        return "redirect:/empleadozona/lista";
    }

    // ***************** EMPLEADO (Mis Zonas) **********************
    @GetMapping("/mis-zonas")
    public String misZonas(@AuthenticationPrincipal User user, Model model) {

        // buscar el empleado según username
        Empleado empleado = empleadoService.buscarPorUsuario(user.getUsername());

        if (empleado == null) {
            // empleado no encontrado, redirigir o mostrar error
            return "redirect:/login?error=EmpleadoNoEncontrado";
        }

        // obtener zonas; devuelve lista vacía si no hay asignaciones
        List<EmpleadoZona> zonas = empleadoZonaService.findByEmpleado(empleado.getIdEmpleado());
        model.addAttribute("zonas", zonas);
        model.addAttribute("empleado", empleado);

        return "empleadozona/mis-zonas";  // debe existir en templates/empleadozona/mis-zonas.html
    }
}
