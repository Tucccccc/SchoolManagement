package com.example.diemdanh.exception;

import org.apache.coyote.BadRequestException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.example.diemdanh.entity.ExceptionData;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    private ResponseEntity<ExceptionData> buildResponse(Exception ex, HttpStatus status) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMsg(ex.getMessage() + ": " + ex.getCause());
        return ResponseEntity.status(status).body(exceptionData);
    }
	
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionData> handleResponseStatusException(ResponseStatusException ex) {
    	return buildResponse(ex, HttpStatus.UNAUTHORIZED);
    }
	
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionData> handleBadRequest(BadRequestException ex) {
    	return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionData> handleIllegalStateException(IllegalStateException ex) {
    	return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionData> handleConstraintViolation(ConstraintViolationException ex) {
    	return buildResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ExceptionData> handleExpiredJwt(ExpiredJwtException ex) {
    	return buildResponse(ex, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionData> handleGenericException(Exception ex) {
    	return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}