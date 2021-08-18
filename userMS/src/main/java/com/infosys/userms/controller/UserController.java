package com.infosys.userms.controller;

import com.infosys.userms.dto.UserDTO;
import com.infosys.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users/{userId}")
    ResponseEntity<UserDTO> getUserProfile(@Valid @PathVariable String userId){
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    
    @GetMapping("/users/booking/{userId}")
    List<BookingDTO> showMyAppointments(String userId){
        UserDTO user = userService.getUserById(userId);
        return new List<>(user, HttpStatus.FOUND);
    }
}

