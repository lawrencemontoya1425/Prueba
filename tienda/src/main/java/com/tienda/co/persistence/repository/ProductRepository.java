package com.tienda.co.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.co.persistence.entity.ProductsEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {

	 public ProductsEntity findByName (String name); 
	
}
