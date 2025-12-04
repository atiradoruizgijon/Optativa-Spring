package com.taskhub.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskhub.demo.model.Tarea;
import com.taskhub.demo.model.TipoTarea;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



// @RequestMapping("/tarea")
@Controller
public class TareaController {
    
    private ArrayList<Tarea> tareas = new ArrayList<>();

    @PostMapping("/crearTarea")
    public String crearTarea(HttpSession session, @RequestParam TipoTarea tipo, String titulo, String descripcion) {
        tareas.add(new Tarea(tipo, titulo, descripcion));
        // meto las tareas en una sesion
        session.setAttribute("tareas", tareas);
        return "redirect:/";
    }
    
    @PostMapping("/borrarTarea")
    public String borrarTarea(HttpSession session, @RequestParam int indice) {
        // obtento el indice de la tarea y la borro del arraylist
        tareas.remove(indice);
        // actualizo la sesion
        session.setAttribute("tareas", tareas);
        return "redirect:/";
    }

    @PostMapping("/completarTarea")
    public String completar(HttpSession session, @RequestParam int indice) {
        tareas.get(indice).setCompletada(true);
        // al completar la tarea, se pondrá la hora y fecha actual
        tareas.get(indice).setFechaCompletada(LocalDate.now());
        // actualizo la sesion
        session.setAttribute("tareas", tareas);
        return "redirect:/";
    }

    @PostMapping("/iniciarSesion")
    public String usuario(HttpSession session, HttpServletResponse response, @RequestParam String usuario) {
        session.setAttribute("usuario", usuario);
        // creo una cookie para el usuario:
        Cookie cookie = new Cookie("usuario", usuario);
        // le pongo el tiempo de vida 1 dia
        cookie.setMaxAge(24*3600);

        // añado la cookie a la página
        response.addCookie(cookie);
        /*
        cookie.setPath("/tarea");
        por si quiero que se restringa hacia una url
        
        Para borrar:
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        
        si no lo añado a respose, no se borra. Para modificarla, tengo que añadirla tambien
        
        si quiero modificarla
        cookie.setValue(usuario);
        */
        return "redirect:/";
    }
    @PostMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session, @CookieValue(name = "usuario") String usuario, HttpServletResponse response) {
        Cookie cookie = new Cookie("usuario", null);
        // borro la cookie y la sesion
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        session.invalidate();

        return "redirect:/inicio";
    }
    
}