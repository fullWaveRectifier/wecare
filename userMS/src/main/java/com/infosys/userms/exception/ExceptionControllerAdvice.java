package com.infosys.userms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(WeCareException.class)
    public final ResponseEntity<String> handleAllExceptions(WeCareException ex) {
        WeCareException exceptionResponse =
                new WeCareException(
                        ex.getMessage());
        return new ResponseEntity(exceptionResponse.message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
