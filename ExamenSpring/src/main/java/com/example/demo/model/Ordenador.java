package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordenador {
	private String id;
	private int precio;
	private Periferico perifericoDeRegalo;
	
	public Ordenador(String id, int precio) {
		this.id = id;
		this.precio = precio;
		
	 	int aleatorio = (int) (Math.random() * 5);
	 	switch (aleatorio) {
	 	case 0:
	 		this.perifericoDeRegalo = Periferico.CPU;
	 		break;
	 	case 1:
	 		this.perifericoDeRegalo = Periferico.DISCO_DURO;
	 		break;
	 	case 2:
	 		this.perifericoDeRegalo = Periferico.PLACA_BASE;
	 		break;
	 	case 3:
	 		this.perifericoDeRegalo = Periferico.RAM;
	 		break;
	 	case 4:
	 		this.perifericoDeRegalo = Periferico.TARJETA_GRAFICA;
	 		break;
		}

	}
}
