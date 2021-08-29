package com.tienda.co.dto;

import java.io.Serializable;

import com.tienda.co.persistence.entity.TypeProductEntity;

public class ProductsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String descripcion;
	private String precio;
	private Integer cantidadMaxima;
	private Integer cantidadMinima;
	private TypeProductEntity typeProductEntity;
	
	

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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public TypeProductEntity getTypeProductEntity() {
		return typeProductEntity;
	}

	public void setTypeProductEntity(TypeProductEntity typeProductEntity) {
		this.typeProductEntity = typeProductEntity;
	}

}
