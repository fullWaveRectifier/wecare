package com.infosys.userms.service;

import com.infosys.userms.dto.LoginDTO;
import com.infosys.userms.dto.UserDTO;

import java.util.List;

public interface UserService {
String createUser(UserDTO userDTO);
	UserDTO getUserById(String id);
	Boolean userLogin(LoginDTO login);
}
