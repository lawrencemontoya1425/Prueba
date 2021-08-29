package com.tienda.co.dto;

import java.io.Serializable;

public class FactProductoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduct;
	private Long idFact;	
	private Integer cantidad;
	private Double precioUnitario;
	
	
	
	
	public FactProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Long getIdFact() {
		return idFact;
	}
	public void setIdFact(Long idFact) {
		this.idFact = idFact;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	 
}
