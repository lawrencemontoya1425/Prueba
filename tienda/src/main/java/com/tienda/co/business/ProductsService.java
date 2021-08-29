package com.tienda.co.business;

import java.util.List;

import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.ProductsDTO;

public interface ProductsService {

	public List<ProductsDTO> findAllProducts ();
	
	public GeneralDTO createProoduct( ProductsDTO client);
	
	public GeneralDTO updateProduct( ProductsDTO client);
	
}
