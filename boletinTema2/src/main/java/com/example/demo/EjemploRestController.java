package com.example.demo;

import org.springframework.boot.web.server.Cookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class EjemploRestController {
	
	@GetMapping("/buenasTardes")
	public String setSession(HttpSession session) {
		session.setAttribute("usuario", "Alejandro");
		String usuario = (String) session.getAttribute("asd");
		// como tenemos restcontroller lo que va a devolver es esto, no un html:
		return "Sesion creada para el usuario ";
	}
	@GetMapping("/get")
	public String getSession(HttpSession session) {
		return "";
	}
	
//	@GetMapping("/")
//	public String setCookie() {
//		Cookie cookie = new Cookie("username", "Ruben");
//	}
	
}
