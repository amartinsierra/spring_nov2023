package com.buscador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buscador.model.Direccion;
import com.buscador.repository.DireccionesRepository;

@Service //anotación para indica a Spring que debe instanciar esta clase
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	DireccionesRepository direccionesRepository;
	
	@Override
	public List<Direccion> busquedaPorTematica(String tematica) {
		
		return direccionesRepository.findByTematica(tematica);
	}
	@Override
	public boolean altaDireccion(Direccion direccion) {
		//si no existe URL se da de alta
		if(direccionesRepository.findById(direccion.getUrl()).isEmpty()) {
			direccionesRepository.save(direccion);
			return true;
		}
		return false;
		
	}
	@Override
	public boolean modificarDireccion(Direccion direccion) {
		//si existe esa dirección, la actualizamos con save
		if(direccionesRepository.findById(direccion.getUrl()).isPresent()) {
			direccionesRepository.save(direccion);
			return true;
		}
		return false;
		
		
	}
	@Override
	public List<Direccion> eliminarDireccionesTematica(String tematica) {
		direccionesRepository.deleteByTematica(tematica);
		return direccionesRepository.findAll();
	}

}
