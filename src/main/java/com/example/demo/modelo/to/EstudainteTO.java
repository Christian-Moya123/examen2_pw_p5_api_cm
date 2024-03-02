package com.example.demo.modelo.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.modeloo.Estudiante;

public class EstudainteTO extends RepresentationModel<EstudainteTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String cedula;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	

}
