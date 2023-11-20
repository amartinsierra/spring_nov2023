package com.buscador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Direccion> buscarDirecciones(@RequestParam("tematica") String tematica){
		return buscadorService.busquedaPorTematica(tematica);
	}
}
