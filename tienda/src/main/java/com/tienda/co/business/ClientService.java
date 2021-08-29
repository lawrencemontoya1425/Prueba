package com.tienda.co.business;

import java.util.List;

import com.tienda.co.dto.ClientDTO;
import com.tienda.co.dto.GeneralDTO;

public interface ClientService {

	public List<ClientDTO> getAllClients();
	
	public ClientDTO getClientByIdentificacion(String identificacion);
	
	public GeneralDTO createClient( ClientDTO client);
	
	public GeneralDTO updateClient( ClientDTO client);
	
}
