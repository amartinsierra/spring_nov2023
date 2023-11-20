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
	@Override
	public boolean altaDireccion(Direccion direccion) {
		//si no hay ninguna dirección con esa url, la añadimos
		//si hay alguna, modificamos
		if(direcciones.stream().noneMatch(d->d.getUrl().equals(direccion.getUrl()))) {
			direcciones.add(direccion);
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean modificarDireccion(Direccion direccion) {
		for(Direccion d:direcciones) {
			//si encontramos la dirección con misma URL, cambiamos resto de datos
			if(d.getUrl().equals(direccion.getUrl())) {
				d.setDescripcion(direccion.getDescripcion());
				d.setTematica(direccion.getTematica());
				return true;
			}
		}
		return false;
		
	}
	@Override
	public List<Direccion> eliminarDireccionesTematica(String tematica) {
		direcciones.removeIf(d->d.getTematica().equals(tematica));
		return direcciones;
	}

}
