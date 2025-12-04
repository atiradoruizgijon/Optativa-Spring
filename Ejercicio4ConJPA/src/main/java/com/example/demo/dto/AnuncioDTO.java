package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioDTO {

	/*
	Clase para transferir datos, pasamos directamente el AnuncioDTO
	y asi no tienes 
	*/

	private String nombre;
	private String asunto;
	private String descripcion;
	
}