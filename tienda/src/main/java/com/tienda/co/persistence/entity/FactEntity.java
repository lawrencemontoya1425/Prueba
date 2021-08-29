package com.tienda.co.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACT")
public class FactEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="idClient")
	private Long idClient; 
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="total")
	private Double total;
	/*
	 @OneToMany(mappedBy = "product")
	 private List<FactProductoEntity> factProducts = new ArrayList<>();*/
  
 

	public FactEntity() {
		super();
		 
	}

	public FactEntity(Long id, ClientEntity clienteEnt, Date fecha, Double total) {
		
		this.id = null;
		this.idClient = null;
		this.fecha = null;
		this.total = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
/*
	public List<FactProductoEntity> getFactProducts() {
		return factProducts;
	}

	public void setFactProducts(List<FactProductoEntity> factProducts) {
		this.factProducts = factProducts;
	}

	 */

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	 

 
	
	
	
}
