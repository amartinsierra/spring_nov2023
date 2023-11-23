package com.estudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.exceptions.AltaException;
import com.estudiantes.model.Estudiante;
import com.estudiantes.service.EstudiantesService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class EstudiantesController {
	@Autowired
	EstudiantesService estudiantesService;
	
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@Parameter(description = "datos del estudiante")@RequestBody Estudiante estudiante){
		try {
			estudiantesService.altaEstudiante(estudiante);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(AltaException ex) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value="aprobados",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> aprobados(){
		return new ResponseEntity<List<Estudiante>>(estudiantesService.aprobados(),HttpStatus.OK);
	}
}
