package com.infosys.bookingms.service;

import com.infosys.bookingms.dto.BookingDTO;
import com.infosys.bookingms.entity.BookingEntity;
import com.infosys.bookingms.exception.ExceptionConstants;
import com.infosys.bookingms.exception.WeCareException;
import com.infosys.bookingms.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
            throw new WeCareException(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString(), HttpStatus.NOT_FOUND.value());
        }
    }

    @Transactional
    @Override
    public Boolean rescheduleAppointment(BookingDTO bookingDTO) {
        BookingEntity oldBookingDetails = bookingRepository.getOne(bookingDTO.getBookingId());
        BookingEntity checkBooking = bookingRepository.findAllBookings(oldBookingDetails.getUserId(), bookingDTO.getAppointmentDate(), bookingDTO.getSlot());
        if(Objects.isNull(checkBooking)){
            oldBookingDetails.setAppointmentDate(bookingDTO.getAppointmentDate());
            oldBookingDetails.setSlot(bookingDTO.getSlot());
            return true;
        }else {
            throw new WeCareException(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString(), HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public BookingDTO findByBookingId(int bookingId) {
        return mapper.map(bookingRepository.getOne(bookingId),BookingDTO.class);
    }

    @Override
    public List<BookingDTO> findBookingByUserId(String userId) {
        List<BookingEntity> listBookingEntity = bookingRepository.findBookingByUserId(userId,LocalDate.now());
        Type listType = new TypeToken<List<BookingDTO>>(){}.getType();
        return mapper.map(listBookingEntity,listType);
    }

    @Override
    public List<BookingDTO> findBookingByCoachId(String coachId) {
        List<BookingEntity> listBookingEntity = bookingRepository.findBookingByCoachId(coachId,LocalDate.now());
        System.out.println(listBookingEntity);
        Type listType = new TypeToken<List<BookingDTO>>(){}.getType();
        return mapper.map(listBookingEntity,listType);
    }
}
