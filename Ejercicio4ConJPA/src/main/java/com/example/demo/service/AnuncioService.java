package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AnuncioDTO;
import com.example.demo.model.Anuncio;

/*
    Interfaz del servicio
*/

public interface AnuncioService {
    
    public void crearAnuncio(AnuncioDTO anuncio);
    public List<Anuncio> findAll();
    public Anuncio encontrarPorId(Long id);
}
