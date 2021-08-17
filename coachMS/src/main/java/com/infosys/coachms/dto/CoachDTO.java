package com.infosys.coachms.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CoachDTO {
    private String coachId;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 50,message = "{name.error}")
    private String name;
    private String gender;
    private LocalDate date_of_birth;
    @NotNull(message = "{field.empty}")
    @Size(min = 5,max = 10, message = "{password.error}")
    private String password;
    @NotNull(message = "{field.empty}")
    @Min(1000000000L)
    @Max(9999999999L)
    private long mobile_number;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 50,message = "{speciality.error}")
    private String speciality;

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}