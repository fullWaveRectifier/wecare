package com.infosys.userms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;


public class ErrorResponse {
    @Autowired
    private MessageSource messageSource;

    private String message;
    private int errorCode;

    public ErrorResponse(String message, int errorCode) {
        this.message = message;
//        this.message = messageSource.getMessage("user.not.found", null, Locale.US);
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;


    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
