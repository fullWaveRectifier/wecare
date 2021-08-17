package com.infosys.bookingms.service;

import com.infosys.bookingms.dto.BookingDTO;
import com.infosys.bookingms.entity.BookingEntity;
import com.infosys.bookingms.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Boolean bookAppointment(BookingDTO bookingDTO) {

        BookingEntity checkBooking = bookingRepository.findAllBookings(bookingDTO.getUserId(), bookingDTO.getAppointmentDate(), bookingDTO.getSlot());
        if (Objects.isNull(checkBooking)) {
           BookingEntity bookingEntity = bookingRepository.saveAndFlush(mapper.map(bookingDTO,BookingEntity.class));
           return true;
        }else {

        }
    }
}
