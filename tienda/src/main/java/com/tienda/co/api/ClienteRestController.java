package com.tienda.co.api;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.co.business.ClientService;
import com.tienda.co.dto.ClientDTO;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.utils.Constants;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClienteRestController {

	@Autowired
	private ClientService clientService;

	private static final Logger logger = LoggerFactory.getLogger(ProductsResController.class);


	@GetMapping(value="/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ClientDTO>> getAllClients(HttpServletRequest req) {
		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get Products");	

		return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
	}
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClientDTO> getClientByIdentification(HttpServletRequest req,
			@RequestParam(name = "identification", required = true) String identification) {

		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get Products");

		ClientDTO client = clientService.getClientByIdentificacion(identification);

		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeneralDTO> createclient(HttpServletRequest req,
			@RequestBody(required = true) ClientDTO client) {

		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Create Products");
		GeneralDTO response = new GeneralDTO();


		try {
			GeneralDTO list = clientService.createClient(client);

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.setMesagge(Constants.ERROR_SAVE);
			logger.info(Constants.FORMATO_LOG, Constants.ERROR, Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeneralDTO> updateClient(HttpServletRequest req,
			@RequestBody(required = true) ClientDTO client, BindingResult result) {

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
			GeneralDTO list = clientService.updateClient(client);

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.setMesagge(Constants.ERROR_SAVE);
			logger.info(Constants.FORMATO_LOG, Constants.ERROR, Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

}