package com.buscador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.buscador.model.Direccion;

public interface DireccionesRepository extends JpaRepository<Direccion, String> {
	List<Direccion> findByTematica(String tematica);
	@Transactional
	@Modifying
	void deleteByTematica(String tematica);
}
