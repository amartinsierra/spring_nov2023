package com.buscador.service;

import java.util.List;

import com.buscador.model.Direccion;

public interface BuscadorService {
	List<Direccion> busquedaPorTematica(String tematica);
	boolean altaDireccion(Direccion direccion);
	boolean modificarDireccion(Direccion direccion);
	List<Direccion> eliminarDireccionesTematica(String tematica);
}
