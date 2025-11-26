package com.example.demo.controller;

import com.example.demo.model.Laptop;
import com.example.demo.model.PC;
import com.example.demo.model.Periferico;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GestionController {
	
	// listas donde guardare los ordenadores
	static List<Laptop> listaLap = new ArrayList<>();
	static List<PC> listaPC = new ArrayList<>();
	
	// valores por defecto de las listas:
	static {
		listaLap.add(new Laptop("L001", 800, Periferico.CPU));
		listaLap.add(new Laptop("L002", 950, Periferico.RAM));
		listaPC.add(new PC("P001", 700, Periferico.DISCO_DURO));
		listaPC.add(new PC("P002", 1200, Periferico.PLACA_BASE));
	}
	
	@RequestMapping("/")
	public String index(HttpServletResponse response, Model model) {
		Cookie ultimoAcceso = new Cookie("ultimoAcceso", String.valueOf(LocalTime.now()));
		ultimoAcceso.setMaxAge(24*3600); // un dia
		response.addCookie(ultimoAcceso);
		
		if (listaLap.size() > listaPC.size()) {
			model.addAttribute("mensaje", "Hay más portátiles que PC");
		}
		if (listaLap.size() == listaPC.size()) {
			model.addAttribute("mensaje", "Hay la misma cantidad de portátiles y PC");			
		}
		if (listaLap.size() < listaPC.size()) {
			model.addAttribute("mensaje", "Hay más PC que portátiles");			
		}
		int total = 0;
		for (Laptop laptop : listaLap) {
			total += laptop.getPrecio();
		}
		for (PC pc : listaPC) {
			total += pc.getPrecio();
		}
		
		model.addAttribute("precioTotal", total);
		model.addAttribute("listaL", listaLap);
		model.addAttribute("listaP", listaPC);
		return "index";
	}
	@RequestMapping("/nuevo")
	public String nuevo(String aviso) {
		return "/nuevo";
	}
	@RequestMapping("/nuevoLaptop")
	public String nuevoLaptop(Model model, @RequestParam String id, int precio) {
		for (Laptop laptop : listaLap) {
			if (laptop.getId().equals(id)) {
				model.addAttribute("aviso", true);
				return "redirect:/nuevo?aviso=true";
			}
		}
		listaLap.add(new Laptop(id, precio));
		return "redirect:/";
	}
	@RequestMapping("/nuevoPC")
	public String nuevoPC(Model model, @RequestParam String id, int precio) {
		for (PC pc : listaPC) {
			if (pc.getId().equals(id)) {
				model.addAttribute("aviso", true);
				return "redirect:/nuevo?aviso=true";
			}
		}
		listaPC.add(new PC(id, precio));
		return "redirect:/";
	}
	@RequestMapping("/eliminarCookie")
	public String eliminarCookie(HttpServletResponse response, @CookieValue(name = "ultimoAcceso") String acceso) {
		Cookie ultimoAcceso = new Cookie("ultimoAcceso", null);
		ultimoAcceso.setMaxAge(0);
		response.addCookie(ultimoAcceso);
		return "redirect:/";
	}
	@RequestMapping("/resumen")
	public String resumen(Model model) {
		int total = 0;
		for (Laptop laptop : listaLap) {
			total += laptop.getPrecio();
		}
		for (PC pc : listaPC) {
			total += pc.getPrecio();
		}
		int totalComprado = listaLap.size() + listaPC.size();
		
		model.addAttribute("totalPrecio", total);
		model.addAttribute("totalComprado", totalComprado);
		return "resumen";
	}
}
