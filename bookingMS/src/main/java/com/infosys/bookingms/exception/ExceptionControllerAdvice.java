package com.infosys.bookingms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

//    @ExceptionHandler(WeCareException.class)
//    public final ResponseEntity<String> handleAllExceptions(WeCareException ex) {
//        WeCareException exceptionResponse =
//                new WeCareException(
//                        ex.getMessage());
//        return new ResponseEntity(exceptionResponse.message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @Autowired
    MessageSource mssgSource;

    @ExceptionHandler(WecareException.class)
    public ErrorResponse exceptionHandler2(WecareException ex) {
        WecareException exceptionResponse =
                new WecareException(ex.getMessage(), ex.getErrorCode());
        return new ErrorResponse(exceptionResponse.getMessage(), exceptionResponse.getErrorCode());

    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//
//        List<String> errorList = new ArrayList();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//
//            errorList.add(errorMessage);
//        });
//        return errorList.get(0);
//    }
}
