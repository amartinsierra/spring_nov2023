package com.buscador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buscador.model.Direccion;
import com.buscador.service.BuscadorService;
@CrossOrigin("*")
@RestController
public class BuscadorController {
	@Autowired
	BuscadorService buscadorService;
	@GetMapping(value="buscar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Direccion>> buscarDirecciones(@RequestParam("tematica") String tematica){
		return new ResponseEntity<>(buscadorService.busquedaPorTematica(tematica),HttpStatus.OK);
	}
	
	//alta
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Direccion direccion) {
		if(buscadorService.altaDireccion(direccion)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	//actualización
	@PutMapping(value="actualizacion",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> actualizar(@RequestBody Direccion direccion) {
		if(buscadorService.modificarDireccion(direccion)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	//eliminación
	@DeleteMapping(value="eliminar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Direccion>> eliminarDirecciones(@RequestParam("tematica") String tematica){
		return new ResponseEntity<>(buscadorService.eliminarDireccionesTematica(tematica),HttpStatus.OK);
	}
}
