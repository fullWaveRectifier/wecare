package com.infosys.userms.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDTO {
    private String userId;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 50, message = "{name.error}")
    private String name;
    @NotNull(message = "{field.empty}")
    @Size(min = 5,max = 10,message = "{password.error}")
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    @NotNull(message = "{field.empty}")
    @Min(value = 1000000000L,message = "{mobileNumber.error}")
    @Max(value = 9999999999L,message = "{mobileNumber.error}")
    private long mobileNumber;
    @Email(message = "{email.error}")
    private String email;
    @NotNull(message = "{field.empty}")
    @Min(value = 100000,message = "{pincode.error}")
    @Max(value = 999999,message = "{pincode.error}")
    private int pincode;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 20,message = "{address.error}")
    private String city;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 20,message = "{address.error}")
    private String state;
    @NotNull(message = "{field.empty}")
    @Size(min = 3,max = 20,message = "{address.error}")
    private String country;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
