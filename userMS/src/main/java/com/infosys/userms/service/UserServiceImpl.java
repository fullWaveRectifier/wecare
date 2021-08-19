package com.infosys.userms.service;

import com.infosys.userms.dto.BookingDTO;

import com.infosys.userms.dto.LoginDTO;

import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.entity.UserEntity;
import com.infosys.userms.exception.WeCareException;
import com.infosys.userms.exception.ExceptionConstants;
import com.infosys.userms.repository.UserRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
    public Boolean loginUser(LoginDTO login) {
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
	@HystrixCommand(fallbackMethod = "fallbackFindBookingByUserId")
	public List<BookingDTO> findBookingByUserId(String userId) {
	    ResponseEntity<BookingDTO[]> userInst = restTemplate.getForEntity("http://BookingMS/users/booking/" + userId, BookingDTO[].class);
	    BookingDTO[] bookings = userInst.getBody();
	    return Arrays.asList(bookings);
    }
	
	public String createUser(UserDTO userDTO) {
		
		userRepo.save(mapper.map(userDTO,UserEntity.class));
		return "Your Profile is Created Successfully User id is:"+userDTO.getUserId();

	}

	public List<BookingDTO> fallbackFindBookingByUserId(String userId){
		return Collections.emptyList();
	}

}
