
package com.tienda.co.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class FactProductId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "idProduct")
	private Long idProduct;

	@Column(name = "idFact")
	private Long idFact;

	public FactProductId(Long idProduct, Long idFact) {
		super();
		this.idProduct = idProduct;
		this.idFact = idFact;
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

}
