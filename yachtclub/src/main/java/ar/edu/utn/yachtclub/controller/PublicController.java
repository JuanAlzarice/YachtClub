package ar.edu.utn.yachtclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/about")
    public String about() {
        // Renderiza la vista about.html
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        // Renderiza la vista contact.html
        return "contact";
    }
}