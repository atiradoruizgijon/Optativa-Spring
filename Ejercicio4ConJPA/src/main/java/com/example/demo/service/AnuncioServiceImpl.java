package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AnuncioDTO;
import com.example.demo.model.Anuncio;
import com.example.demo.repository.AnuncioRepository;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    /*
    Utilizar un service nos ayuda a prevenir inyección SQL.
    Un servicio es una clase en la que implementamos los metodos
    que utilizaremos alrededor de nuestro modelo, ya sea para
    hacer un CRUD u otros aspectos.
    Esto se hace para no tocar la clase del modelo directamente
    ya que esta se comportará como una tabla en la base de datos
    con @Entity.
    */

    @Autowired
    AnuncioRepository anuncioRepository;

    @Override
    public void crearAnuncio(AnuncioDTO anuncio) {
        Anuncio anuncioNuevo = new Anuncio();
        anuncioNuevo.setNombre(anuncio.getNombre());
        anuncioNuevo.setAsunto(anuncio.getAsunto());
        anuncioNuevo.setDescripcion(anuncio.getDescripcion());

        anuncioRepository.save(anuncioNuevo);
    }

    @Override
    public List<Anuncio> findAll() {
        if (anuncioRepository.findAll() == null) {
            return new ArrayList<Anuncio>();
        }
        return anuncioRepository.findAll();
    }

    @Override
    public Anuncio encontrarPorId(Long id) {
        // si no encuentra un anuncio con la id que se le pasa, devuelve null
        return anuncioRepository.findById(id).orElse(null);
    }
    
}
