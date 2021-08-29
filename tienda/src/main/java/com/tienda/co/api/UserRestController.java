package com.tienda.co.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.co.business.impl.UserServiceImpl;
import com.tienda.co.dto.UserDTO;
import com.tienda.co.utils.Constants;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserServiceImpl userServ;

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> getUser(HttpServletRequest req, @RequestBody(required = true) UserDTO userDto) {
		logger.info(Constants.FORMATO_LOG, "Start Process: ", "Get User");

		UserDTO user = userServ.findByPassAndUser(userDto);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
