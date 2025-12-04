package com.taskhub.demo.dto;

import java.time.LocalDate;

import com.taskhub.demo.model.TipoTarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TareaDTO {
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
