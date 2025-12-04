package com.taskhub.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTarea;
    @NonNull
    private TipoTarea tipo;
    @NonNull
    private String titulo;
    @NonNull
    private String descripcion;
    private boolean completada = false;
    private LocalDate fechaCreacion = LocalDate.now();
    private LocalDate fechaCompletada = null;
}
