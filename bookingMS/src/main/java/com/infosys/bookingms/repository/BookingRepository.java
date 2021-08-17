package com.infosys.bookingms.repository;

import com.infosys.bookingms.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

    Optional<BookingEntity> findByUserId(String userId);

    @Query(value = "SELECT s FROM BookingEntity s WHERE s.userId = :userId AND s.appointmentDate >= :today")
    List<BookingEntity> findBookingByUserId(String userId, LocalDate today);

    @Query(value = "SELECT s FROM BookingEntity s WHERE s.coachId = :coachId AND s.appointmentDate >= :today")
    List<BookingEntity> findBookingByCoachId(String coachId, LocalDate today);

    @Query(value = "SELECT s FROM BookingEntity s WHERE s.userId = :userId AND s.appointmentDate = :today AND s.slot =:slot ")
    BookingEntity findAllBookings(String userId, LocalDate appointmentDate, String slot);
}
