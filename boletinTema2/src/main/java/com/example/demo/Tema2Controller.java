package com.example.demo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tema2.Anuncio;
import tema2.Contacto;
import tema2.Sexo;

@Controller
public class Tema2Controller {

    private final OptativaSpringBootApplication optativaSpringBootApplication;

    Tema2Controller(OptativaSpringBootApplication optativaSpringBootApplication) {
        this.optativaSpringBootApplication = optativaSpringBootApplication;
    }
	
	// @Override @GetMapping son lo que se llaman 'beans'
	
	@GetMapping("/nuevoAnuncio") // petición de dirreccion web o desde el formulario
	public String metodo() {
		return "Tema2/nuevoAnuncio"; // ¿A qué HTML me voy?
	}
	
	@GetMapping("/anuncio") // petición de dirreccion web o desde el formulario
	public String metodo(@RequestParam("nombre") String nombre, @RequestParam("asunto") String asunto, @RequestParam("comentario") String comentario, Model model) {
		model.addAttribute("nombre", nombre); // le digo a model que lleve a "nombre"
		model.addAttribute("asunto", asunto); // le digo a model que lleve a "nombre"
		model.addAttribute("comentario", comentario); // le digo a model que lleve a "nombre"
		return "Tema2/anuncio"; // ¿A qué HTML me voy?
	}
	
	/*
	 * Hay 4 formas de mandar datos:
	 * 1. Lo mando con Model que es como una caja donde mando los datos a otra pagina
	 * 2. Base de Datos / Fichero
	 * 3. Sesiones que se destruyen al cerrar el navegaor
	 * 4. Cookies que se guardan en tu ordenador hasta que caducan o se borran
	 * */
	
	
	static ArrayList<Contacto> contactos = new ArrayList<>();
	
	static LocalDate fecha = LocalDate.now();
	
	static {		
		contactos.add(new Contacto("Juan", "Perez", "jp@gmail.com", Sexo.Hombre));
		contactos.add(new Contacto("Maria", "Lopez", "ml@gmail.com", Sexo.Mujer));
		contactos.add(new Contacto("Beto", "Luna", "bluna@gmail.com", Sexo.Hombre));
	}
	
	@GetMapping("/Tema2/Ejercicio2")
	public String ejercicio2(Model model) {
		
		model.addAttribute("fecha", fecha);
		model.addAttribute("arraylist", contactos);
		return "Tema2/Ejercicio2";
	}
	
	@GetMapping("/Tema2/Ejercicio3")
	public String ejercicio3() {
		return "Tema2/Ejercicio3";
	}
	
	@GetMapping("/enlace")
	public String ejercicio3enlace(@RequestParam int nenlace, Model model) {
		model.addAttribute("nenlace", nenlace);
		System.out.println("Pasa por el controlador.");
		return "Tema2/enlace";
	}
	
	// Defino el array
	static List<Anuncio> anuncios = new ArrayList<>();
	
	static String nombreEsc = "";
	
	@GetMapping("Tema2/anuncioEj4")
	public String anuncioEj4(Model model) {
		model.addAttribute("anuncios", anuncios);
		
		String bienvenida = "";
		if (anuncios.isEmpty()) bienvenida = "Bienvenido al tablon de anuncios.";
		model.addAttribute("bienvenida", bienvenida);
		model.addAttribute("nombreEsc", nombreEsc);
		
		return "Tema2/anuncioEj4";
	}
	
	@GetMapping("/insertado")
	public String insertado(@RequestParam String nombre, String asunto, String descripcion, Model model) {
		// Inserto el anuncio en la lista.
		anuncios.add(new Anuncio(nombre, asunto, descripcion));
		nombreEsc = nombre;
		
		return "Tema2/insertado";
	}
	
	@GetMapping("Tema2/nuevoAnuncioEj4")
	public String nuevoAnuncioEj4(@RequestParam String nombreEsc, Model model) {
		model.addAttribute("nombreEsc", nombreEsc);
		
		return "Tema2/nuevoAnuncioEj4";
	}
	
	@GetMapping("Tema2/mostrarAnuncioEj4")
	public String mostrarAnuncioEj4(@RequestParam int indice, Model model) {
		// Segun el indice pasado, obtengo el anuncio que quiero.
		model.addAttribute("anuncioEscogido", anuncios.get(indice));
		
		return "Tema2/mostrarAnuncioEj4";
	}
	
	
	// Ejercicio 4 con sesiones:
	
	static List<Anuncio> anunciosSesion = new ArrayList<>();
	
	@GetMapping("/anuncioTabla")
	public String peticionTablaAnuncios(HttpSession session , Model model) {
		if (!session.isNew()) {
			boolean bienvenida = (boolean) session.getAttribute("bienvenida");			
			model.addAttribute("bienvenida", bienvenida);
		}
		
		model.addAttribute("anuncios", anunciosSesion);
		return "Tema2/anuncioTabla";	
	}
	
	@GetMapping("/hacerAnuncio")
	public String peticionHacerAnuncio(HttpSession session, Model model) {
		// creo una sesion boolean que al pasar por este controlador indique true
		session.setAttribute("bienvenida", true);
		return "Tema2/hacerAnuncio";
	}
	
	@GetMapping("/insertarSesion")
	public String peticionInsertar(@RequestParam String nombre, String asunto, String comentario, Model model) {
		anunciosSesion.add(new Anuncio(nombre, asunto, comentario));
		return "redirect:anuncioTabla";
	}
	
	@GetMapping("/anuncioMostrar")
	public String peticionMostrarAnuncio(@RequestParam int indice, Model model) {
		model.addAttribute("anuncioEscogido", anunciosSesion.get(indice));
		return "Tema2/anuncioMostrar";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
