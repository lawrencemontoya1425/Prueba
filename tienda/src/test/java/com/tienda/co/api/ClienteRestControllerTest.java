package com.tienda.co.api;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.tienda.co.TiendaApplication;
import com.tienda.co.business.ClientService;
import com.tienda.co.dto.ClientDTO;
import com.tienda.co.dto.TypeIdenticationDTO;
import com.tienda.co.utilidades.Constants;

import io.restassured.RestAssured;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TiendaApplication.class)
public class ClienteRestControllerTest {

	@Autowired
	private ClientService clienteService;
	
	@BeforeClass
	public static void setup() {
        RestAssured.port = Integer.valueOf(9091);//Constants.PUERTO_CONSULTAS
        //RestAssured.basePath = Constants.BASE_PATH;
        RestAssured.baseURI = "http://localhost";
	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllClients_ok() {
		String hd = RestAssured
		.given() 
		.log() 
		.all() 
		.port(9091)
		.when() 
		.get(Constants.BASE_PATH + Constants.URL_GET_CLIENTS)  
		.then() 
		.log() 
		.all() 
		.statusCode(200).extract().body().asString(); 

	}
	
	@Test
	public void getClientByIdentification_ok() {
		String hd1 = RestAssured
		.given() 
		.log() 
		.all() 
		.queryParam(Constants.IDENTIFICATION_PARAM, Constants.IDENTIFICATION_VAL) 
		.port(9091)
		.when() 
		.get(Constants.BASE_PATH + Constants.URL_GET_CLIENTS)  
		.then() 
		.log() 
		.all() 
		.statusCode(200).extract().body().asString(); 

	}
	
	@Test
	public void createClient_ok() {
		
		TypeIdenticationDTO dto = new TypeIdenticationDTO();
		dto.setId(1L);
		dto.setName("Cedula");
		
		ClientDTO dtoClient = new ClientDTO();
		dtoClient.setEmail("PruebaAutomatica@hotmail.com");
		dtoClient.setPhone("3214536111");
		dtoClient.setAddress("calle 130");
		dtoClient.setIdentificacion("93136769");
		dtoClient.setTypeIdentification(dto);
		dtoClient.setName("Prueba Automatica");
		
		
		String hd1 = RestAssured
		.given() 
		.log() 
		.all() 
		.and()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(dtoClient)
		.port(9091)
		.when() 
		.post(Constants.BASE_PATH )  
		.then() 
		.log() 
		.all() 
		.statusCode(200).extract().body().asString(); 

	}
	

	@Test
	public void updateClient_ok() {
		
		TypeIdenticationDTO dto = new TypeIdenticationDTO();
		
		ClientDTO dtoUpdtae = clienteService.getClientByIdentificacion("93136769");
		
		dtoUpdtae.setName("Modificado");		
				
		String hd1 = RestAssured
		.given() 
		.log() 
		.all() 
		.and()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(dtoUpdtae)
		.port(9091)
		.when() 
		.put(Constants.BASE_PATH )  
		.then() 
		.log() 
		.all() 
		.statusCode(200).extract().body().asString(); 

	}
	
	
}
