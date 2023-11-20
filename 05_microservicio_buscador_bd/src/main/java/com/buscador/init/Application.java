package com.buscador.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.buscador.repository")
@EntityScan(basePackages = "com.buscador.model")
@SpringBootApplication(scanBasePackages = {"com.buscador.controller","com.buscador.service"}) //equivale a @Configuration+@ComponentScan+@EnableConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
