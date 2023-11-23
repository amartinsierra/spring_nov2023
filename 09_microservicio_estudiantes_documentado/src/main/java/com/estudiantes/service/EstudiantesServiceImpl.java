package com.estudiantes.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import com.estudiantes.exceptions.AltaException;
import com.estudiantes.model.Estudiante;

@Service
public class EstudiantesServiceImpl implements EstudiantesService {
	@Autowired
	WebClient webClient;
	
	String urlBase="http://localhost:9000/formacion/";

	@Override
	public void altaEstudiante(Estudiante estudiante) throws AltaException{
		//capturamos posible excepción por código de estado 4xx y propagamos
		//excepción personalizada al controller
		try {
			webClient
				.post() //RequestBodyUriSpec
				.uri(urlBase+"alta")  //RequestBodySpec
				.contentType(MediaType.APPLICATION_JSON) //RequestBodySpec
				//.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				//.body(BodyInserters.fromFormData("username", "SOME-USERNAME")
                //.with("password", "SONE-PASSWORD"))
				.bodyValue(estudiante)  //RequestHeadersSpec
				.retrieve() //ResponseSpec
				.bodyToMono(Void.class) //Mono<Void>
				.block();
		}
		catch(WebClientResponseException ex) {
			throw new AltaException();
		}

	}

	@Override
	public List<Estudiante> aprobados() {
		Estudiante[] estudiantes=webClient
			.get()
			.uri(urlBase+"alumnos")
			.retrieve()
			.bodyToMono(Estudiante[].class)
			.block(); //Estudiante[]
		
		return Arrays.stream(estudiantes)
				.filter(e->e.getNota()>=5)
				.toList();
	}

	@Override
	public Estudiante buscarEstudiante(String email) {
		UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(urlBase+"alumno")
				.queryParam("email", email)
				//.queryParam("unidades", e.getUnidades());
				;
		return webClient
			.get()
			//.uri(urlBase+"alumno?email="+email)
			.uri(builder.toUriString())
			.retrieve()
			.bodyToMono(Estudiante.class)
			.block();
	}

}
