package com.alumnos.init.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alumnos.init.model.Alumno;
import com.alumnos.init.repository.AlumnosRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService {

	@Autowired
	AlumnosRepository alumnosRepository;
	@Override
	public boolean altaAlumno(Alumno alumno) {
		if(alumnosRepository.findByEmail(alumno.getEmail()).isEmpty()) {
			alumnosRepository.save(alumno);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void eliminarAlumno(String email) {
		if(alumnosRepository.findByEmail(email).isPresent()) {
			alumnosRepository.deleteByEmail(email);
		}

	}

	

	@Override
	public List<String> cursos() {
		/*return alumnosRepository.findAll().stream()
				.map(a->a.getCurso()) //Stream<String>
				.distinct()
				.collect(Collectors.toList());*/
		return alumnosRepository.cursos();
	}

	@Override
	public List<Alumno> alumnosCurso(String curso) {
		return alumnosRepository.findByCurso(curso);
	}

	@Override
	public Alumno buscarAlumno(String email) {
		return alumnosRepository.findByEmail(email).orElse(null);
	}

	@Override
	public List<Alumno> alumnos() {
		return alumnosRepository.findAll();
	}

}
