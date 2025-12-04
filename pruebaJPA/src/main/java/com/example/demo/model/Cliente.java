package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    // va a pasar a ser una tabla con @Entity
    // con @Id marcamos la primary key
    // con CrudRepository<Cliente, Long>, con Long indicamos el tipo de la primary key

    // este bean es, si queremos darle un alias personalizado en la tabla.
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // Para que sea AUTO_INCREMENT
    @Column(name = "id")
    private Long idCliente;
    private String nombre;
    private String apellido;

    // Constructor vacío
    protected Cliente() {}

    public Cliente(Long idCliente, String nombre, String apellido) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + "]";
    }
}
