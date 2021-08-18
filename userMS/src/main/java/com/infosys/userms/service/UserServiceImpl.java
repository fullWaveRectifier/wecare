package com.infosys.userms.service;

import com.infosys.userms.dto.BookingDTO;

import com.infosys.userms.dto.LoginDTO;

import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.entity.UserEntity;
import com.infosys.userms.exception.WeCareException;
import com.infosys.userms.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO getUserById(String id) {
        Optional<UserEntity> user = userRepo.findById(id);
        System.out.println(user.isPresent());
        if(user.isPresent()) return mapper.map(user.get(), UserDTO.class);
        else throw new WeCareException("askjfaklsjflasjfkl", HttpStatus.OK.value());
    }
    
    @Override
    public Boolean userLogin(LoginDTO login) {
    	String id= login.getId();
    	String password = login.getPassword();
    	Optional<UserEntity> result =  userRepo.findById(id);
    	if(result.isPresent()) {
    		UserDTO user = mapper.map(result.get(), UserDTO.class);
    		if(user.getPassword().equals(password)) {
    			return true;
    		}
    		else {
    			throw new WeCareException("COACH_NOT_FOUND", HttpStatus.OK.value());
    		}
    	}
    	else {
    		throw new WeCareException("COACH_NOT_FOUND", HttpStatus.OK.value());
    	}
    }

	@Override
	public List<BookingDTO> findBookingByUserId(String userId) {
	    Optional<UserEntity> userList = userRepo.findByUserId(userId);
		
		return null;
	}

}
