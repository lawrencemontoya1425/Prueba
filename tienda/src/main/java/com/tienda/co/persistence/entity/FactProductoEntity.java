package com.tienda.co.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FACT_PRODUCT")
 
public class FactProductoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PkFactProduc id;

	@Column(name = "cantidad")
	private Long cantidad;

	@Column(name = "precioUnitario")
	private Double precioUnitario;

	@Column(name = "total")
	private Double total;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @MapsId("idProduct")
	 * 
	 * @JoinColumn(name="idProduct") private ProductsEntity product;
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @MapsId("idFact")
	 * 
	 * @JoinColumn(name="idFact") private FactEntity fact;
	 */

	/*
	 * public PkFactProduc getId() { return id; }
	 * 
	 * public void setId(PkFactProduc id) { this.id = id; }
	 */

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public PkFactProduc getId() {
		return id;
	}

	public void setId(PkFactProduc id) {
		this.id = id;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
