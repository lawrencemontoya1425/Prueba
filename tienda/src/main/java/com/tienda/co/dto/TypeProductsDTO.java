package com.tienda.co.dto;

import java.io.Serializable;

public class TypeProductsDTO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
