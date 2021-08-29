package com.tienda.co.business.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.co.business.UserService;
import com.tienda.co.dto.UserDTO;
import com.tienda.co.persistence.entity.UserEntity;
import com.tienda.co.persistence.repository.UsersRepository;
import com.tienda.co.utils.EncriptadorAES;
import com.tienda.co.utils.MapperUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public UserDTO findByPassAndUser(UserDTO userDto) {

		try {
			final String claveEncriptacion = "secreto!";
			EncriptadorAES encriptador = new EncriptadorAES();
			UserEntity user = userRepo.findByUserAndPass(encriptador.encriptar(userDto.getUser(), claveEncriptacion), encriptador.encriptar(userDto.getPass(), claveEncriptacion));
			if (user == null) {
				return null;
			}else {
				user.setPass(encriptador.desencriptar(user.getPass(), claveEncriptacion) );
				user.setUser(encriptador.desencriptar(user.getUser(), claveEncriptacion) );
				return MapperUtil.convertToDto(user, UserDTO.class);				
			}


		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException ex) {
			return null;
		}

	}

}
