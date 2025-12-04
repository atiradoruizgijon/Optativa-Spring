package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Anuncio;


/*
    Repositorio, hace las operaciones desde la base de datos
    el crud, modificar, eliminar, crear, etc.
*/
@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
