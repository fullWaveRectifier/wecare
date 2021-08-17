package com.infosys.bookingms.service;

import com.infosys.bookingms.dto.BookingDTO;

public interface BookingService {
    Boolean bookAppointment(BookingDTO bookingDTO);
}
