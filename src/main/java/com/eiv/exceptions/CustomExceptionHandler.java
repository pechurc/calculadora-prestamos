package com.eiv.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleAll(Exception ex, WebRequest request) {

	        return ResponseEntity.badRequest().body(ex.getCause().getCause().getMessage());
	    }
}
