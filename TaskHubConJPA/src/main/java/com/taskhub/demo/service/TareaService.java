package com.taskhub.demo.service;

import com.taskhub.demo.dto.TareaDTO;

public interface TareaService {
    public void crearAnuncio(TareaDTO tarea);
    public void borrarAnuncio(Long id);
}
