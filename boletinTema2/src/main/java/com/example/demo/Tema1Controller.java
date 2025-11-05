package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Tema1Controller {
	
	/*
	 * El servlet es el que coge la informacion y la muestra,
	 * responde a solicitudes HTTP enviando páginas HTML,
	 * JSON u otros formatos.
	 * 
	 *  Cookies de sesion: variables que se guardan y estan
	 *  activas mientras esta el navegaddora activo.
	 *  
	 *  atributos importantes:
	 *  id: identificador de la sesion
	 *  creationTime: momento en la que se creo
	 *  lastAccessedTime: ultimavez que se accedio
	 *  max
	 *  
	 *  Cookies persistentes: variables que se guardan
	 *  hasta que nosotros queramos.
	 *  
	 *  atributos importantes:
	 *  name: nombre de la cookie (unico por dominio)
	 *  value: valor de la cookie
	 *  maxAge: tiempo de vida en segundos
	 *  secure: si true, solo se envia en http
	 * 
	 * */
	@GetMapping("/mipagina")
	public String metodo(HttpSession session, Model model) {
		String nombre = (String) session.getAttribute("miNombre");
		if (nombre == null) {
			nombre = "Invitado";
		}
		model.addAttribute("nombreUsuario", nombre);
		return "redirect:/mipagina";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
