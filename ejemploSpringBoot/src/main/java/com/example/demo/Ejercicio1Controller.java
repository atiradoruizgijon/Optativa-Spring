package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio1Controller {
	
	@GetMapping("") // petición de dirreccion web o desde el formulario
	public String metodo() {
		return "nuevoAnuncio"; // ¿A qué HTML me voy?
	}
	
	@GetMapping("/anuncio") // petición de dirreccion web o desde el formulario
	public String metodo(@RequestParam("nombre") String nombre, @RequestParam("asunto") String asunto, @RequestParam("comentario") String comentario, Model model) {
		model.addAttribute("nombre", nombre); // le digo a model que lleve a "nombre"
		model.addAttribute("asunto", asunto); // le digo a model que lleve a "nombre"
		model.addAttribute("comentario", comentario); // le digo a model que lleve a "nombre"
		return "anuncio"; // ¿A qué HTML me voy?
	}
}
