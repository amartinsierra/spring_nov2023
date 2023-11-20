package com.buscador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion {
	@Id
	private String url;
	private String tematica;
	@Column(name = "descripcion")
	private String descripcion;
	public Direccion(String url, String tematica, String descripcion) {
		super();
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	
	public Direccion() {
		super();
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
