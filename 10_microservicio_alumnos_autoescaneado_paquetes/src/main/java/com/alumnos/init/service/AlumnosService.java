package com.alumnos.init.service;

import java.util.List;

import com.alumnos.init.model.Alumno;

public interface AlumnosService {
	boolean altaAlumno(Alumno alumno);
	void eliminarAlumno(String email);
	Alumno buscarAlumno(String email);
	List<String> cursos();
	List<Alumno> alumnosCurso(String curso);
	List<Alumno> alumnos();
}
