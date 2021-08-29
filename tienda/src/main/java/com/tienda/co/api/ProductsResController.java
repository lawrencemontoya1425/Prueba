package com.tienda.co.api;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.co.business.ProductsService;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.ProductsDTO;
import com.tienda.co.utils.Constants;
 

@RestController
@RequestMapping("/products")
@CrossOrigin(origins= "*")
public class ProductsResController {

	@Autowired
	private ProductsService prodService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsResController.class);
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductsDTO>> getProducts(HttpServletRequest req) {
		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get Products");

		List<ProductsDTO> list = new ArrayList<ProductsDTO>();
		list = prodService.findAllProducts(); 

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeneralDTO> createclient(HttpServletRequest req,
			@RequestBody(required = true) ProductsDTO product) {

		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Create Products");
		GeneralDTO response = new GeneralDTO();


		try {
			GeneralDTO list = prodService.createProoduct(product);

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.setMesagge(Constants.ERROR_SAVE);
			logger.info(Constants.FORMATO_LOG, Constants.ERROR, Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeneralDTO> updateClient(HttpServletRequest req,
			@RequestBody(required = true) ProductsDTO product, BindingResult result) {

		logger.info(Constants.FORMATO_LOG, "Start Process: ", "update Products");
		GeneralDTO response = new GeneralDTO();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.setMesagge(errors.toString());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			GeneralDTO list = prodService.updateProduct(product);

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.setMesagge(Constants.ERROR_SAVE);
			logger.info(Constants.FORMATO_LOG, Constants.ERROR, Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	


}