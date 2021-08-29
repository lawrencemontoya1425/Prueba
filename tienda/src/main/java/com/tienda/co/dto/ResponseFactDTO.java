package com.tienda.co.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResponseFactDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private ClientDTO client;
	private String fecha;
	private Double total;
	private List<DetalleDTO> listDetalles;

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

	public List<DetalleDTO> getListDetalles() {
		return listDetalles;
	}

	public void setListDetalles(List<DetalleDTO> listDetalles) {
		this.listDetalles = listDetalles;
	}

}
