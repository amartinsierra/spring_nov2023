package com.estudiantes.model;

public class Estudiante {
	private String nombre;
	private String curso;
	private String email;
	private double nota;
	public Estudiante(String nombre, String curso, String email, double nota) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}
	public Estudiante() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
