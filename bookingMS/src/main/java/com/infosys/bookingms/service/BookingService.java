package com.infosys.bookingms.service;

import com.infosys.bookingms.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    Boolean bookAppointment(BookingDTO bookingDTO);

    Boolean rescheduleAppointment(BookingDTO bookingDTO);

    BookingDTO findByBookingId(int bookingId);

    List<BookingDTO> findBookingByUserId(String userId);

    List<BookingDTO> findBookingByCoachId(String coachId);


}
