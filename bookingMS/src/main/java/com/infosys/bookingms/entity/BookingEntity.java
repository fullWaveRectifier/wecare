package com.infosys.bookingms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookingtable")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    int bookingId;
    @Column(name = "user_id")
    String userId;
    @Column(name = "coach_id")
    String coachId;
    @Column(name = "slot")
    String slot;
    @Column(name = "appointment_date")
    LocalDate appointmentDate;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
