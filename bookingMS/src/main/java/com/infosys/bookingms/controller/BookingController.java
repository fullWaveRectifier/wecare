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
import java.util.List;

@RestController
@Validated
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/users/{userId}/booking/{coachId}")
    public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId, @PathVariable String coachId,@Valid @RequestBody BookingDTO bookingDTO){
        bookingDTO.setUserId(userId);
        bookingDTO.setCoachId(coachId);


        return new ResponseEntity<>(bookingService.bookAppointment(bookingDTO),HttpStatus.OK);
    }

    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable int bookingId,@Valid @RequestBody BookingDTO bookingDTO){
        bookingDTO.setBookingId(bookingId);

        return new ResponseEntity<>(bookingService.rescheduleAppointment(bookingDTO),HttpStatus.OK);
    }

    @GetMapping("/coaches/booking/{coachId}")
    public List<BookingDTO> getCoachBookingList(@PathVariable String coachId){
        return bookingService.findBookingByCoachId(coachId);
    }

    @GetMapping("/users/booking/{userId}")
    public List<BookingDTO> getUserBookingList(@PathVariable String userId){
        return bookingService.findBookingByUserId(userId);
    }

}
