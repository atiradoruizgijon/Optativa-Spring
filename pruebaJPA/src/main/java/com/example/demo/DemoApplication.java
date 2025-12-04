package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepository repository) {
		return (args) -> {
			// guardar clientes:
			repository.save(new Cliente("Pablo", "Roman"));
			repository.save(new Cliente("Alejandro", "Tirado"));

			// recoger clientes:
			log.info("Clientes encontrados con findAll():");
			log.info("-----------------------------------");

			for (Cliente cliente : repository.findAll()) {
				log.info(cliente.toString());
			}
			log.info("");

			Optional cliente = repository.findById(1L);
			log.info("Cliente encontrado con findById(1L)");
			log.info("-----------------------------------");
			log.info(cliente.toString());
			log.info("");

			// recogerlos por apellido:
			log.info("Cliente encontrado con findByApellido('Roman')");
			log.info("-----------------------------------");
			
			repository.findByApellido("Roman").forEach(roman -> {
				log.info(roman.toString());
			});
			// for (Customer roman : repository.findByLastName("Roman")) {
			// log.info(roman.toString());
			// }
			log.info("");
		};
	}
}
