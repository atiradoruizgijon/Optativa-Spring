package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Laptop extends Ordenador {
	private String imagePath;
	
	public Laptop(String id, int precio) {
		super(id, precio);
		this.imagePath = "../portatil.jpg";
	}
	public Laptop(String id, int precio, Periferico perifericoDeRegalo) {
		super(id, precio, perifericoDeRegalo);
		this.imagePath = "../portatil.jpg";
	}
}
