package com.tienda.co;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tienda.co.persistence.entity.ClientEntity;
import com.tienda.co.persistence.entity.EmployeeEntity;
import com.tienda.co.persistence.entity.ProductsEntity;
import com.tienda.co.persistence.entity.TypeIdenticationEntity;
import com.tienda.co.persistence.entity.TypeProductEntity;
import com.tienda.co.persistence.entity.UserEntity;
import com.tienda.co.persistence.repository.ClientRepository;
import com.tienda.co.persistence.repository.EmployeeRepository;
import com.tienda.co.persistence.repository.ProductRepository;
import com.tienda.co.persistence.repository.TypeIdenticationRepository;
import com.tienda.co.persistence.repository.TypeProductRepository;
import com.tienda.co.persistence.repository.UsersRepository;
import com.tienda.co.utils.EncriptadorAES;

@SpringBootApplication
public class TiendaApplication {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private TypeProductRepository typeProductRepo;

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private TypeIdenticationRepository tipoIdentiRepo;

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private UsersRepository userRepo;	

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {

		tipoIdentiRepo.save(new TypeIdenticationEntity(1L, "Cedula"));
		tipoIdentiRepo.save(new TypeIdenticationEntity(2L, "Tarjeta"));
		tipoIdentiRepo.save(new TypeIdenticationEntity(3L, "Passport"));

		typeProductRepo.save(new TypeProductEntity(1L, "Muñeco Iron Man", "Muñeco Grande Articulado"));
		typeProductRepo.save(new TypeProductEntity(2L, "Muñeco Hulk", "Muñeco Pequeño Articulado"));
		typeProductRepo.save(new TypeProductEntity(3L, "Vaso", "Vaso Grande"));
		typeProductRepo.save(new TypeProductEntity(4L, "Comics", "Comics"));
		typeProductRepo.save(new TypeProductEntity(5L, "Camisetas", "Camisetas"));
		typeProductRepo.save(new TypeProductEntity(6L, "Juguete", "juguete"));
		 
		ProductsEntity p = new ProductsEntity();
 		final String claveEncriptacion = "secreto!";
 		EncriptadorAES encriptador = new EncriptadorAES();
 		
		p.setId(1L);
		p.setTypeProductEntity(new TypeProductEntity (1L, "Muñeco Iron Man", "Muñeco Grande Articulado") );
		p.setName("Muñeco Iron Man");
		p.setDescripcion("Muñeco Iron Man Grande articulado");
		p.setPrecio(encriptador.encriptar("150000", claveEncriptacion));
		p.setCantidadMaxima(500);
		p.setCantidadMinima(1);
		productRepo.save(p); 
		
		ProductsEntity p2 = new ProductsEntity();
		
		p2.setId(2L);
		p2.setTypeProductEntity(new TypeProductEntity (2L, "Muñeco Hulk", "Muñeco Pequeño Articulado") );
		p2.setName("Muñeco Hulk");
		p2.setDescripcion("Muñeco Hulk Pequeño articulado");
		p2.setPrecio(encriptador.encriptar("50000", claveEncriptacion));
		p2.setCantidadMaxima(500);
		p2.setCantidadMinima(1);
		productRepo.save(p2); 		
		

		ProductsEntity p3 = new ProductsEntity();
		
		p3.setId(3L);
		p3.setTypeProductEntity(new TypeProductEntity (3L, "Vaso", "Vaso Wolverine Grande") );
		p3.setName("Vaso Wolverine");
		p3.setDescripcion("Vaso Wolverine Grande");
		p3.setPrecio(encriptador.encriptar("45000", claveEncriptacion));
		p3.setCantidadMaxima(500);
		p3.setCantidadMinima(1);
		productRepo.save(p3);
		
		ProductsEntity p4 = new ProductsEntity();
		
		p4.setId(4L);
		p4.setTypeProductEntity(new TypeProductEntity (4L, "Comics", "Comics") );
		p4.setName("Comic Capitan America I");
		p4.setDescripcion("Comic Capitan America I");
		p4.setPrecio(encriptador.encriptar("56000", claveEncriptacion));
		p4.setCantidadMaxima(500);
		p4.setCantidadMinima(1);
		productRepo.save(p4);
		
		ProductsEntity p5 = new ProductsEntity();
		
		p5.setId(5L);
		p5.setTypeProductEntity(new TypeProductEntity (4L, "Comics", "Comics") );
		p5.setName("Comic Bruja Escarlata");
		p5.setDescripcion("Comic Bruja Escarlata c");
		p5.setPrecio(encriptador.encriptar("512000", claveEncriptacion));
		p5.setCantidadMaxima(500);
		p5.setCantidadMinima(1);
		productRepo.save(p5);
		 
		ClientEntity ent = new ClientEntity();
		ent.setId(1L);
		ent.setEmail("lawren_montoya@hotmail.com");
		ent.setPhone("3214536111");
		ent.setAddress("calle 130");
		ent.setIdentificacion("93136770");
		ent.setTypeIdentification(new TypeIdenticationEntity(1L, "Cedula"));
		ent.setName("Lawrence Montoya");
		clientRepo.save(ent);

		EmployeeEntity enti = new EmployeeEntity();
		enti.setId(1L);
		enti.setEmail("Stellaa@hotmail.com");
		enti.setPhone("3114855738");
		enti.setAddress("calle 130");
		enti.setIdentificacion("65708494");
		enti.setTypeIdentification(new TypeIdenticationEntity(1L, "Cedula"));
		enti.setName("Stella Suarez");
		employeeRepo.save(enti);

		// (1L, "Lawrence Montoya",1L, "93136770", "calle
		// 130","lawren_montoya@hotmail.com","3214536111")
		// employeeRepo.save(new EmployeeEntity(1L,"Stella Suarez",1L,"65708494","kra 1
		// n 67","sfes@gmail.com","3114855979") );

		UserEntity user1 = new UserEntity();
		user1.setPass("m0WpJ2pKIM51e5xl+dcg/A==");
		user1.setUser("N80jWvGn7KdmMzPWTcSyjw==");
		user1.setDateCreation(new Date() );
		userRepo.save(user1);

		UserEntity user2 = new UserEntity();
		user2.setPass("m0WpJ2pKIM51e5xl+dcg/A==");
		user2.setDateCreation(new Date() );		
		user2.setUser("0tjyO4ccdqsO4zE6LZkUlg==");
		userRepo.save(user2);

		return null;

	}
}
