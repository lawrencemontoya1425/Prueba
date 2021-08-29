package com.tienda.co.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.co.business.Type⁯IdentificationServices;
import com.tienda.co.dto.TypeIdenticationDTO;
import com.tienda.co.utils.Constants;

@RestController
@RequestMapping("/identifications")
@CrossOrigin(origins = "*")
public class Type⁯IdentificationRestControlller {


	@Autowired
	private Type⁯IdentificationServices identServ;

	private static final Logger logger = LoggerFactory.getLogger(Type⁯IdentificationRestControlller.class);
	
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TypeIdenticationDTO>> getAllIdentification(HttpServletRequest req) {
		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get Products");	

		return new ResponseEntity<>(identServ.getAllIdentification(), HttpStatus.OK);
	}

}
