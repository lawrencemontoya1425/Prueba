package com.tienda.co.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.co.business.impl.FactServiceImpl;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.RequestFactDTO;
import com.tienda.co.dto.ResponseFactDTO;
import com.tienda.co.utils.Constants;

@RestController
@RequestMapping("/facts")
@CrossOrigin(origins= "*")

public class FactRestController {

	
	@Autowired
	private FactServiceImpl factService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsResController.class);

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseFactDTO> getById(HttpServletRequest req,
			@RequestParam(name = "id", required = true) Long id) {
		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get Products");

		ResponseFactDTO list = factService.getById(id); 

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeneralDTO> createclient(HttpServletRequest req,
			@RequestBody(required = true) RequestFactDTO fact) {

		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Create Products");
		GeneralDTO response = new GeneralDTO();


		try {
			GeneralDTO list = factService.createFact(fact);

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.setMesagge(Constants.ERROR_SAVE);
			logger.info(Constants.FORMATO_LOG, Constants.ERROR, Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
}
