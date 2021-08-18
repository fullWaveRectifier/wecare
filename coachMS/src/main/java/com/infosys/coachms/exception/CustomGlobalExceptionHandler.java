package com.infosys.coachms.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.coachms.dto.ErrorMessage;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(AllSignUpFieldException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(AllSignUpFieldException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessage handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		
	    List<String> errorList = new ArrayList();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errorList.add(errorMessage);
	    });
	    return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),errorList.get(0));
	}
}
