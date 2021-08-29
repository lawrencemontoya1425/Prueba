package com.tienda.co.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class ClientEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER, targetEntity=TypeIdenticationEntity.class)
	@JoinColumn(name="idTipoIdent", referencedColumnName = "id")
	private TypeIdenticationEntity typeIdentification; 
	
		 
	public ClientEntity() {
	 
		this.id = null;
		this.name = null;
		this.typeIdentification = null;	 
		this.identificacion = null;
		this.address = null;
		this.email = null;
		this.phone = null;
	}

	

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

	public TypeIdenticationEntity getTypeIdentification() {
		return typeIdentification;
	}

	public void setTypeIdentification(TypeIdenticationEntity typeIdentification) {
		this.typeIdentification = typeIdentification;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}