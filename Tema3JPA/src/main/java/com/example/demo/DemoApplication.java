package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.com.example.demo.model.Cliente;
import main.java.com.example.demo.model.ClienteRepository;

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

			Cliente cliente = repository.findById(1L);
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
