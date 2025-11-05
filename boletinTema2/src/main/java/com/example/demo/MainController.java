package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// Creo un índice para navegar mejor entre ejercicios.
	// Mapping que me lleve al índice.
	@GetMapping({"", "/"})
	public String indice() {
		return "index";
	}
}
