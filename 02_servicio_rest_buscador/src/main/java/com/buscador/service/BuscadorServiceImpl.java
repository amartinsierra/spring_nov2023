package com.buscador.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.buscador.model.Direccion;

@Service //anotación para indica a Spring que debe instanciar esta clase
public class BuscadorServiceImpl implements BuscadorService {
	static List<Direccion> direcciones=new ArrayList<>(Arrays.asList(new Direccion("http://www.amazon.es","libros","web de libros y más cosas"),
			new Direccion("http://www.fnac.es","libros","libreria completa"),
			new Direccion("http://www.travel.es","viajes","viajes por el mundo"),
			new Direccion("http://www.game.es","juegos","el mundo del juego"),
			new Direccion("http://www.fly.com","viajes","vuelos a todos los destinos"),
			new Direccion("http://www.casadellibro.es","libros","libros de todos los temas")
			));
	@Override
	public List<Direccion> busquedaPorTematica(String tematica) {
		/*List<Direccion> aux=new ArrayList<>();
		for(Direccion d:direcciones) {
			if(d.getTematica().equals(tematica)) {
				aux.add(d);
			}
		}
		return aux;*/
		
		return direcciones.stream()
				.filter(d->d.getTematica().equals(tematica))
				.toList();
	}

}
