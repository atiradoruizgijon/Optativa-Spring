package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PC extends Ordenador {
	private String imagePath;
	
	public PC(String id, int precio) {
		super(id, precio);
		this.imagePath = "../pc.jpg";
	}
	public PC(String id, int precio, Periferico perifericoDeRegalo) {
		super(id, precio, perifericoDeRegalo);
		this.imagePath = "../pc.jpg";
	}
	
	
}
