package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AnuncioDTO;
import com.example.demo.service.AnuncioServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class AnuncioController {

	/*
		Autowired: te crea la instancia. 
		
		private AnuncioServiceImpl anuncioServiceImpl
		AnuncioController(AnuncioServiceImpl anuncioServiceImpl) {
			this.anuncioServiceImpl = anuncioServiceImpl;
		}
	*/
	@Autowired
	AnuncioServiceImpl anuncioServiceImpl;
	
	@GetMapping({"/anuncioTabla", "/"})
	public String peticionTablaAnuncios(HttpSession session , Model model) {
		Boolean bienvenida = (Boolean) session.getAttribute("bienvenida");
		if (bienvenida != null) {
			model.addAttribute("bienvenida", bienvenida);
		}
		session.setAttribute("bienvenida", true);
		model.addAttribute("anuncios", anuncioServiceImpl.findAll());
		return "/anuncioTabla";
	}

	@GetMapping("/hacerAnuncio")
	public String peticionHacerAnuncio(HttpSession session, Model model) {
		String nombreSesion = (String) session.getAttribute("nombreSesion");
		
		if (nombreSesion != null) {
			model.addAttribute("nombreSesion", nombreSesion);
		} else {
			model.addAttribute("nombreSesion", "");
		}
		return "/hacerAnuncio";
	}
	
	@PostMapping("/insertarSesion")
	public String peticionInsertar(@ModelAttribute AnuncioDTO anuncio, Model model, @RequestParam String nombre, HttpSession session) {
		anuncioServiceImpl.crearAnuncio(anuncio);
		session.setAttribute("nombreSesion", nombre);
		return "redirect:anuncioTabla";
	}
	
	@RequestMapping("/anuncioMostrar")
	public String peticionMostrarAnuncio(@RequestParam Long id, Model model) {
		model.addAttribute("anuncioEscogido", anuncioServiceImpl.encontrarPorId(id));
		return "/anuncioMostrar";
	}
}