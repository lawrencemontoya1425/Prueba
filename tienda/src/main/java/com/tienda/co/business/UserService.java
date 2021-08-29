package com.tienda.co.business;

import com.tienda.co.dto.UserDTO;

public interface UserService {

	public UserDTO findByPassAndUser(UserDTO userDto);
}
