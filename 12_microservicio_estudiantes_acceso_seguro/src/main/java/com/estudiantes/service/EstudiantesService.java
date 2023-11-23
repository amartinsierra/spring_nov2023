package com.estudiantes.service;

import java.util.List;

import com.estudiantes.exceptions.AltaException;
import com.estudiantes.model.Estudiante;

public interface EstudiantesService {
	void altaEstudiante(Estudiante estudiante) throws AltaException;
	List<Estudiante> aprobados();
	Estudiante buscarEstudiante(String email);
}
