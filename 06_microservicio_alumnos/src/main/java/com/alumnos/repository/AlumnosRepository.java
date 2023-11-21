package com.alumnos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.alumnos.model.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer>{	
	
	List<Alumno> findByCurso(String curso);
	
	Optional<Alumno> findByEmail(String email);
	
	@Modifying
	@Transactional
	void deleteByEmail(String email);
	
	//@Query("select distinct a.curso from Alumno a")
	@Query(value="select distinct curso from alumnos",nativeQuery = true)
	List<String> cursos();
	
	
	
	
}
