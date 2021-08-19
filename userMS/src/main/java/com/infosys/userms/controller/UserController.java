package com.infosys.userms.controller;

import com.infosys.userms.dto.BookingDTO;
import com.infosys.userms.dto.LoginDTO;
import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.exception.WeCareException;
import com.infosys.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users/{userId}")
    ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId){
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
    @GetMapping("/users/booking/{userId}")
    List<BookingDTO> showMyAppointments(@PathVariable String userId){
        return userService.findBookingByUserId(userId);
    }


    @PostMapping("/users")
    ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO),HttpStatus.OK);

    }

    @PostMapping("/users/login")
    ResponseEntity<Boolean> loginUser(@Valid @RequestBody LoginDTO login){
    	try {
    		Boolean result = userService.loginUser(login);
			return new ResponseEntity<Boolean>(result,HttpStatus.OK);
		} catch (WeCareException e) {
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}

    }
}

