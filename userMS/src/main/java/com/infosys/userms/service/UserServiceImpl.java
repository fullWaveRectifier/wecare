package com.infosys.userms.service;

import com.infosys.userms.dto.BookingDTO;

import com.infosys.userms.dto.LoginDTO;

import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.entity.UserEntity;
import com.infosys.userms.exception.WeCareException;
import com.infosys.userms.exception.ExceptionConstants;
import com.infosys.userms.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDTO getUserById(String id) {
        Optional<UserEntity> user = userRepo.findById(id);
        System.out.println(user.isPresent());
        if(user.isPresent()) return mapper.map(user.get(), UserDTO.class);
        else throw new WeCareException(ExceptionConstants.USER_NOT_FOUND.toString(), HttpStatus.OK.value());
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
    			throw new WeCareException(ExceptionConstants.USER_NOT_FOUND.toString(), HttpStatus.OK.value());
    		}
    	}
    	else {
    		throw new WeCareException(ExceptionConstants.USER_NOT_FOUND.toString(), HttpStatus.OK.value());
    	}
    }

	@Override

	public List<BookingDTO> findBookingByUserId(String userId) {
	    Optional<UserEntity> userList = userRepo.findByUserId(userId);
	    ResponseEntity<BookingDTO[]> userInst = restTemplate.getForEntity("http://localhost:8083/users/booking/" + userId, BookingDTO[].class);
//	    ResponseEntity<Employee[]> response =
//	    		  restTemplate.getForEntity(
//	    		  "http://localhost:8080/employees/",
//	    		  Employee[].class);
	    BookingDTO[] bookings = userInst.getBody();
	    		
	   // System.out.println(userList);
		if(userList.isPresent()) {
			return Arrays.asList(bookings);
		}
		else throw new WeCareException(ExceptionConstants.USER_NOT_FOUND.toString(), HttpStatus.BAD_REQUEST.value());
	}
	
	public String createUser(UserDTO userDTO) {
		
		userRepo.save(mapper.map(userDTO,UserEntity.class));
		return "Your Profile is Created Successfully User id is:"+userDTO.getUserId();

	}

}
