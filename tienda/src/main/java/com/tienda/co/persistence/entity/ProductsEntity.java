package com.tienda.co.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class ProductsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private String precio;

	@Column(name = "cantidadMaxima")
	private Integer cantidadMaxima;

	@Column(name = "cantidadMinima")
	private Integer cantidadMinima;

	@ManyToOne(optional = true, fetch = FetchType.EAGER, targetEntity = TypeProductEntity.class)
	@JoinColumn(name = "idTipoProducto", referencedColumnName = "id")
	private TypeProductEntity typeProductEntity;

 
 
	/*
	@OneToMany(mappedBy = "fact")
	private List<FactProductoEntity> factProducts ;

	 public void addAuthor(FactProductoEntity factProducts){
	        if(this.factProducts == null){
	            this.factProducts = new ArrayList<>();
	        }
	        
	        this.factProducts.add(factProducts);
	    }*/
	 
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public TypeProductEntity getTypeProductEntity() {
		return typeProductEntity;
	}

	public void setTypeProductEntity(TypeProductEntity typeProductEntity) {
		this.typeProductEntity = typeProductEntity;
	}
/*
	public List<FactProductoEntity> getFactProducts() {
		return factProducts;
	}

	public void setFactProducts(List<FactProductoEntity> factProducts) {
		this.factProducts = factProducts;
	}
*/
}
