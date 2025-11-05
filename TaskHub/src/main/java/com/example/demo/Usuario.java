package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {
	@NonNull
	private String user;
	@NonNull
	private String passwd;
	private List<String> tareas = new ArrayList<>();
	
	public void ponerTarea(String tarea) {
		tareas.add(tarea);
	}
	
	public void quitarTarea(int indice) {
		tareas.remove(indice);
	}
}
