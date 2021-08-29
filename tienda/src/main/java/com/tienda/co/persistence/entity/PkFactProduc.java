package com.tienda.co.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PkFactProduc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "idProduct")
	private Long idProduct;

	@Column(name = "idFact")
	private Long idFact;

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
