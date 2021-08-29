package com.tienda.co.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.co.business.Type⁯IdentificationServices;
import com.tienda.co.dto.TypeIdenticationDTO;
import com.tienda.co.persistence.entity.TypeIdenticationEntity;
import com.tienda.co.persistence.repository.TypeIdenticationRepository;
import com.tienda.co.utils.MapperUtil;

@Service
public class Type⁯IdentificationServicesImpl implements Type⁯IdentificationServices {

	@Autowired
	private TypeIdenticationRepository repo;
	@Override
	public List<TypeIdenticationDTO> getAllIdentification() {
		List<TypeIdenticationDTO> resp = new ArrayList<>();
		List<TypeIdenticationEntity> list = repo.findAll();
		for(TypeIdenticationEntity dto : list )
			resp.add(MapperUtil.convertToDto(dto, TypeIdenticationDTO.class));
		return resp;
	}	
}
