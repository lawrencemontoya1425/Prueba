package com.tienda.co.dto;

import java.io.Serializable;
import java.util.List;

public class RequestFactDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private ClientDTO client;
	private String fecha;
	private Double total;
	private List<DetalleDTO> detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<DetalleDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleDTO> detalles) {
		this.detalles = detalles;
	}

}
