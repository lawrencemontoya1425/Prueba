package com.tienda.co.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.co.business.ClientService;
import com.tienda.co.dto.ClientDTO;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.persistence.entity.ClientEntity;
import com.tienda.co.persistence.repository.ClientRepository;
import com.tienda.co.utils.Constants;
import com.tienda.co.utils.MapperUtil;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public List<ClientDTO> getAllClients() {
		List<ClientDTO> resp = new ArrayList<>();
		List<ClientEntity> list = clientRepo.findAll();
		for(ClientEntity dto : list )
			resp.add(MapperUtil.convertToDto(dto, ClientDTO.class));
		
		return resp;
	}

	
	@Override
	public ClientDTO getClientByIdentificacion(String identificacion) {		
		ClientEntity list = clientRepo.findAllByIdentificacion(identificacion);
		return MapperUtil.convertToDto(list, ClientDTO.class);
		
	}

	@Override
	public GeneralDTO createClient(ClientDTO client ) {
		GeneralDTO response = new GeneralDTO();
		ClientEntity list = clientRepo.findAllByIdentificacion(client.getIdentificacion());
		if(list == null) {
			clientRepo.save(MapperUtil.convertToEntity(client, ClientEntity.class));
			response.setMesagge(Constants.CLIENTE_SAVE);
		}else {
			response.setMesagge(Constants.ERROR_CLIENT_EXISTS);
		}
		return response;
	}

	@Override
	public GeneralDTO updateClient(ClientDTO client) {
		GeneralDTO response = new GeneralDTO();
		response.setMesagge(Constants.CLIENTE_SAVE);
		clientRepo.save(MapperUtil.convertToEntity(client, ClientEntity.class));
		return response;
	}


}
