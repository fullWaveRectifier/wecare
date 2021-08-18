package com.infosys.userms.service;

import com.infosys.userms.dto.UserDTO;

import java.util.List;

public interface UserService {
UserDTO getUserById(String id);
String createUser(UserDTO userDTO);
}
