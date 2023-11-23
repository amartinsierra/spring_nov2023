package com.alumnos.init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alumnos.init.model.Alumno;
import com.alumnos.init.service.AlumnosService;

@RestController
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	@GetMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> alumnos(){
		return new ResponseEntity<>(alumnosService.alumnos(),HttpStatus.OK);
	}
	@GetMapping(value="alumno",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> alumno(@RequestParam("email") String email){
		return new ResponseEntity<>(alumnosService.buscarAlumno(email),HttpStatus.OK);
	}
	@GetMapping(value="alumnosCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> alumnos(@RequestParam("curso") String curso){
		return new ResponseEntity<>(alumnosService.alumnosCurso(curso),HttpStatus.OK);
	}
	
	@GetMapping(value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> cursos(){
		return new ResponseEntity<>(alumnosService.cursos(),HttpStatus.OK);
	}
	
	@PostMapping(value="alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Alumno alumno){
		if(alumnosService.altaAlumno(alumno)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@DeleteMapping(value="eliminar")
	public ResponseEntity<Void> eliminar(String email){
		alumnosService.eliminarAlumno(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
