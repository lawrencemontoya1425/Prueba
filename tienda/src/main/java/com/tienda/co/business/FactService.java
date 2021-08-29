package com.tienda.co.business;

import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.RequestFactDTO;
import com.tienda.co.dto.ResponseFactDTO;

public interface FactService {

	public ResponseFactDTO getById(Long id);
	
	public GeneralDTO createFact(RequestFactDTO fact);
	
	

}
