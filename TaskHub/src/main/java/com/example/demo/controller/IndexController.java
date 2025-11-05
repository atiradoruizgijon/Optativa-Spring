package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Usuario;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("tareas", usuario.getTareas());
			return "tareas";
		}
		return "index";
	}
	
	// metodo get para ir entre paginas
	@GetMapping("/login")
	public String loginGet() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam String user, String passwd, boolean incorrecto) {
		// recorro la lista de usuarios
		for (Usuario u : usuarios) {
			// si dentro de la lista encuentra uno con el que coincide usuario y contraseña,
			// lo guardamos en la sesion
			if (u.getUser() == user && u.getPasswd() == passwd) {
				session.setAttribute("usuario", u);
				return "redirect:/";
			}
		}
		// si no lo encuentra, recargamos la pagina con un mensaje que hemos introducido el usuario incorrecto
		return "redirect:/login?incorrecto=true";
	}
	
	@GetMapping("/cerrar-sesion")
    public String logout(HttpSession session) {
		// borro la sesion
        session.invalidate();
        return "redirect:/login";
    }
	
	@PostMapping("/agregarTarea")
    public String agregarTarea(HttpSession session, @RequestParam String tarea) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null && tarea != null && !tarea.trim().isEmpty()) {
            usuario.ponerTarea(tarea);
        }
        return "redirect:/tareas";
    }
	
	@PostMapping("/eliminarTarea")
    public String eliminarTarea(HttpSession session, @RequestParam int index) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            usuario.quitarTarea(index);
        }
        return "redirect:/tareas";
    }
	
	@GetMapping("/crear")
	public String crearCuenta() {
		return "crear";
	}
	@PostMapping("/creada")
	public String cuentaCreada(HttpSession session, Model model, @RequestParam String user, String passwd) {
		usuarios.add(new Usuario(user, passwd));
		return "redirect:/";
	}
}
