package com.infosys.coachms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(WeCareException.class)
    public final ErrorResponse handleAllExceptions(WeCareException ex) {
        WeCareException exceptionResponse =
                new WeCareException(ex.getMessage(), ex.getErrorCode());
        return new ErrorResponse(exceptionResponse.getMessage(), exceptionResponse.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errorList = new ArrayList();
        ex.getBindingResult().getAllErrors().forEach(e -> {
//            String fieldName = ((FieldError) e).getField();
              errorList.add(e.getDefaultMessage());
        });
        return new ErrorResponse(errorList.toString(), HttpStatus.BAD_REQUEST.value());
    }
}