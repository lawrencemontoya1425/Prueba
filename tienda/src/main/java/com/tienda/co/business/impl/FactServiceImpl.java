package com.tienda.co.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.co.business.FactService;
import com.tienda.co.dto.ClientDTO;
import com.tienda.co.dto.DetalleDTO;
import com.tienda.co.dto.FactProductoDTO;
import com.tienda.co.dto.GeneralDTO;
import com.tienda.co.dto.ProductsDTO;
import com.tienda.co.dto.RequestFactDTO;
import com.tienda.co.dto.ResponseFactDTO;
import com.tienda.co.persistence.entity.ClientEntity;
import com.tienda.co.persistence.entity.FactEntity;
import com.tienda.co.persistence.entity.FactProductoEntity;
import com.tienda.co.persistence.entity.PkFactProduc;
import com.tienda.co.persistence.entity.ProductsEntity;
import com.tienda.co.persistence.repository.ClientRepository;
import com.tienda.co.persistence.repository.FactProductoRepository;
import com.tienda.co.persistence.repository.FactRepository;
import com.tienda.co.persistence.repository.ProductRepository;
import com.tienda.co.utils.MapperUtil;

@Service
public class FactServiceImpl implements FactService {

	@Autowired
	private FactRepository factRepo;
	
	@Autowired
	private FactProductoRepository factProRepo;
	
	@Autowired
	private ClientRepository clienRepo;
	
	@Autowired
	private ProductRepository prodRepo;

	
	@Override
	public ResponseFactDTO getById(Long id) {
		Optional<FactEntity> entidad = factRepo.findById(id);
		ResponseFactDTO respuesta = new ResponseFactDTO();
		
		if(entidad.isPresent()) {
			respuesta.setFecha(entidad.get().getFecha().toString());
			respuesta.setId(entidad.get().getId());
			respuesta.setTotal(entidad.get().getTotal());
			
			
			Optional<ClientEntity> clientEntity = clienRepo.findById(entidad.get().getIdClient());
			if(clientEntity.isPresent()) {				
				respuesta.setClient(MapperUtil.convertToDto(clientEntity.get(), ClientDTO.class));
				
				List<DetalleDTO> listDetalles = new ArrayList<>(); 
				
				List<FactProductoEntity> listRela =  factProRepo.findByIdFact(entidad.get().getId());
				
				for(FactProductoEntity reg : listRela) {
					
					DetalleDTO dtoDetalle = new DetalleDTO();
					
					Optional<ProductsEntity> ent = prodRepo.findById(reg.getId().getIdProduct());
					
					if(ent.isPresent()) {
						dtoDetalle.setIdProducto(ent.get().getId());
						dtoDetalle.setProducto(ent.get().getName());
						dtoDetalle.setCantidad(reg.getCantidad());
						dtoDetalle.setPrecioUnitario(reg.getPrecioUnitario());
						dtoDetalle.setTotal(reg.getTotal());
						listDetalles.add(dtoDetalle);
						//private Long idProduct;
					}
					
				}
				
				 
				
				respuesta.setListDetalles(listDetalles);
			}
			
		}
		
 
		

		return respuesta;
		
		
	}
	
	@Override
	public GeneralDTO createFact(RequestFactDTO dtoIn) {
		
		
		FactEntity factEntity = new FactEntity(); 
		factEntity.setIdClient(dtoIn.getClient().getId());
		factEntity.setFecha(new Date());
		factEntity.setTotal(dtoIn.getTotal());		 	
		factEntity = factRepo.save(factEntity);
		
		for(DetalleDTO detalle : dtoIn.getDetalles() ) {
			FactProductoEntity reg1 = new FactProductoEntity();
			PkFactProduc pk = new PkFactProduc();
			pk.setIdFact(factEntity.getId() );
			pk.setIdProduct(detalle.getIdProducto());
			
			reg1.setCantidad(detalle.getCantidad());
			reg1.setPrecioUnitario(detalle.getPrecioUnitario());
			reg1.setTotal(reg1.getPrecioUnitario() * reg1.getCantidad());
			reg1.setId(pk);
			
			factProRepo.save(reg1);
		}
		
		
		
		
		GeneralDTO rep = new GeneralDTO();
		rep.setMesagge("ok");
		return rep;
	}
	
}
