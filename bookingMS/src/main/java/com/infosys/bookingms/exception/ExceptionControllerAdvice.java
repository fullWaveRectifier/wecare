package com.infosys.bookingms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions1(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(WeCareException.class)
    public ErrorResponse exceptionHandler2(WeCareException ex) {
        WeCareException exceptionResponse =
                new WeCareException(ex.getMessage(), ex.getErrorCode());
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
