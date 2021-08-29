package com.tienda.co.dto;

import java.io.Serializable;

public class GeneralDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mesagge;
	private String id;

	public GeneralDTO() {
		super();
 	}

	public String getMesagge() {
		return mesagge;
	}

	public void setMesagge(String mesagge) {
		this.mesagge = mesagge;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
