package com.buscador.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buscador.model.Direccion;
import com.buscador.service.BuscadorService;

@Controller
public class BuscadorController {
	//solicitamos a Spring una instancia de la capa service	
	@Autowired
	BuscadorService buscadorService;
	@GetMapping(value="buscar")//el método se ejecutará con peticiones GET de dirección buscar
	public String buscarDirecciones(@RequestParam("tematica") String tematica,HttpServletRequest request) {
		List<Direccion> direcciones=buscadorService.busquedaPorTematica(tematica);
		//pasamos la lista de direcciones a la vista, guardando
		//dicha lista en la memoria del servidor de aplicaciones
		request.setAttribute("direcciones", direcciones);
		//pasamos control a la vista
		return "resultados";
		
	}
	//definir página de inicio o bienvenida
	@GetMapping(value="/")
	public String inicio() {
		return "inicio";
	}
	
	
}
