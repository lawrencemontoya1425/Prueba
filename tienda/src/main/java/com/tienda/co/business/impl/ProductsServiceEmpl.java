package com.tienda.co.business.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.co.business.ProductsService;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.ProductsDTO;
import com.tienda.co.persistence.entity.ProductsEntity;
import com.tienda.co.persistence.repository.ProductRepository;
import com.tienda.co.utils.Constants;
import com.tienda.co.utils.EncriptadorAES;
import com.tienda.co.utils.MapperUtil;

@Service
public class ProductsServiceEmpl implements ProductsService {
	
	@Autowired
	private ProductRepository productRepo;	
		
	@Override
	public List<ProductsDTO> findAllProducts() {
		List<ProductsEntity> list =  productRepo.findAll();
		List<ProductsDTO> response = new ArrayList<>();
		
		for (ProductsEntity reg : list) {
			reg.setPrecio(desencriptar(reg.getPrecio()));
			response.add(MapperUtil.convertToDto(reg, ProductsDTO.class));
		}
		return response;
		
	}


	@Override
	public GeneralDTO createProoduct(ProductsDTO dtoIn) {
		GeneralDTO response = new GeneralDTO();
		ProductsEntity list = productRepo.findByName(dtoIn.getName() );
		if(list == null) {
			dtoIn.setPrecio( encriptar(dtoIn.getPrecio()));
			productRepo.save(MapperUtil.convertToEntity(dtoIn, ProductsEntity.class));
			response.setMesagge(Constants.PRODUCT_SAVE);
		}else {
			response.setMesagge(Constants.ERROR_PRODUCT_EXISTS);
		}
		return response;
	}

	@Override
	public GeneralDTO updateProduct(ProductsDTO dtoIn) {
		GeneralDTO response = new GeneralDTO();
		response.setMesagge(Constants.PRODUCT_SAVE);
		dtoIn.setPrecio( encriptar(dtoIn.getPrecio()));
		productRepo.save(MapperUtil.convertToEntity(dtoIn, ProductsEntity.class));
		return response;
		
	}
 
	private String desencriptar (String valor) {
		String retorno = "";
		try {
			final String claveEncriptacion = "secreto!";
			EncriptadorAES encriptador = new EncriptadorAES();
			retorno = encriptador.desencriptar(valor, claveEncriptacion);
			return retorno;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
		 
	}
	private String encriptar (String valor){
		String retorno = "";
		try {
			final String claveEncriptacion = "secreto!";
			EncriptadorAES encriptador = new EncriptadorAES();
			retorno =  encriptador.encriptar(valor, claveEncriptacion);
			return retorno;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return retorno;
	}
	
 

}
