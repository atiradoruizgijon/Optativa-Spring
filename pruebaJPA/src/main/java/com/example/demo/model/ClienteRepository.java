package com.example.demo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByApellido(String apellido);
    Optional findById(Long idCliente);
}
