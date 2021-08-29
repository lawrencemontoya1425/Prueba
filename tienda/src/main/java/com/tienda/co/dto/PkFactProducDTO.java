package com.tienda.co.dto;

import java.io.Serializable;

public class PkFactProducDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idProduct;
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
