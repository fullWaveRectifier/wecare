package com.infosys.bookingms.controller;

import com.infosys.bookingms.dto.BookingDTO;
import com.infosys.bookingms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/users/{userId}/booking/{coachId}")
    public ResponseEntity<Boolean> bookAppointment(@Valid @PathVariable String userId, @PathVariable String coachId, @RequestBody BookingDTO bookingDTO){
        bookingDTO.setUserId(userId);
        bookingDTO.setCoachId(coachId);

        if(bookingService.bookAppointment(bookingDTO)){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }

    }
}
