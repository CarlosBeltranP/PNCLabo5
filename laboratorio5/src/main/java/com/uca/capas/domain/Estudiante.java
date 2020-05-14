package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Column(name="nombre")
	@Size(min=1, max=5, message = "El campo Nombre debe tener mínimo 1 y máximo de 30 caracteres")
	private String Nombre;
	
	@Size(min=1, max=5, message = "El campo Apellido debe tener mínimo 1 y máximo de 30 caracteres")
	@Column(name="apellido")
	private String Apellido;
	
	@Size(min=8, max=8, message = "El campo Carnet debe tener exactamente 8 digitos")
	@Column(name="carne")
	private String Carnet;
	
	@Size(min=1, max=5, message = "El campo Carrera debe tener mínimo 1 y máximo de 30 caracteres")
	@Column(name="carrera")
	private String Carrera;
	
	public Estudiante() {
		
	}
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCarnet() {
		return Carnet;
	}
	public void setCarnet(String carnet) {
		Carnet = carnet;
	}
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	
	
}