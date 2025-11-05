package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String user;
	private String passwd;
	private List<String> tareas = new ArrayList<>();
	
	public Usuario(String user, String passwd) {
		super();
		this.user = user;
		this.passwd = passwd;
	}

	public Usuario() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<String> getTareas() {
		return this.tareas;
	}
	
	public void ponerTarea(String tarea) {
		tareas.add(tarea);
	}
	
	public void quitarTarea(int indice) {
		tareas.remove(indice);
	}
}
