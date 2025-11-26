package main.java.com.example.demo.model;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByApellido(String apellido);
    Cliente findById(Long idCliente);
}
