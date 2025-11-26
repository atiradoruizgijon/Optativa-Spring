package com.example.demo.clases;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tarea {
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
