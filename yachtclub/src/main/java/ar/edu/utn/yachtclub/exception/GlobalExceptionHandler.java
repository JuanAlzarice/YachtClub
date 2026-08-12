package ar.edu.utn.yachtclub.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(
            ResourceNotFoundException ex,
            Model model) {

        model.addAttribute("titulo", "Recurso no encontrado");
        model.addAttribute("mensaje", ex.getMessage());

        return "errores/error";
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public String handleDuplicate(
            DuplicateResourceException ex,
            Model model) {

        model.addAttribute("titulo", "Registro duplicado");
        model.addAttribute("mensaje", ex.getMessage());

        return "errores/error";
    }

    @ExceptionHandler(BusinessException.class)
    public String handleBusiness(
            BusinessException ex,
            Model model) {

        model.addAttribute("titulo", "Error de negocio");
        model.addAttribute("mensaje", ex.getMessage());

        return "errores/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneral(
            Exception ex,
            Model model) {

        model.addAttribute("titulo", "Error inesperado");
        model.addAttribute("mensaje","Ocurrió un error inesperado.");

        return "errores/error";
    }
}
