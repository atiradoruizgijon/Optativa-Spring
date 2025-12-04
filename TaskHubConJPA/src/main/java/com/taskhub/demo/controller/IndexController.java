package com.taskhub.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskhub.demo.model.Tarea;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(HttpSession session, @CookieValue(name = "usuario", required = false) String usuario, Model model) {
        // en caso de que no haya una cookie con un usuario:
        if (usuario == null) {
            return "redirect:/inicio";
        }
        // mando el nombre de usuario para que lo lea la cookie
        session.setAttribute("usuario", usuario);
        // recupero la sesion de las tareas y las mando para mostrarlas:
        ArrayList<Tarea> tareas = (ArrayList<Tarea>) session.getAttribute("tareas");
        model.addAttribute("tareas", tareas);
        return "index";
    }
    @GetMapping("/inicio")
    public String inicio(@CookieValue(name = "usuario", required = false) String usuario, Model model) {
        // si ya tenemos una sesión nos mandará a la página principal
        if (usuario != null) {
            model.addAttribute("aviso", true);
            return "redirect:/";
        }
        return "inicio";
    }
    @PostMapping("/creacion")
    public String getMethodName() {
        return "creacion";
    }
    
}