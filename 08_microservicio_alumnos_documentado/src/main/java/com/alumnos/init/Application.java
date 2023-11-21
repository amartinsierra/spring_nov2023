package com.alumnos.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.alumnos.repository")
@EntityScan(basePackages = "com.alumnos.model")
@SpringBootApplication(scanBasePackages = {"com.alumnos.controller","com.alumnos.service"}) 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
