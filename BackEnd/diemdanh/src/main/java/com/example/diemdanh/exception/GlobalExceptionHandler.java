package com.example.diemdanh.exception;

import org.apache.coyote.BadRequestException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.diemdanh.entity.ExceptionData;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionData> handleBadRequest(BadRequestException ex) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionData);
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionData> handleIllegalStateException(IllegalStateException ex) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionData);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionData> handleConstraintViolation(ConstraintViolationException ex) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMessage(ex.getMessage()+ ": " + ex.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionData);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionData> handleDataIntegrity(DataIntegrityViolationException ex) {
    	String errorMessage = ex.getRootCause().getMessage();
    	ExceptionData exceptionData = new ExceptionData();
    	ResponseEntity<ExceptionData> resEntity;
        if (errorMessage.contains("cannot be null")) {
        	exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        	resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionData);
        } else if (errorMessage.contains("Duplicate entry") || errorMessage.contains("foreign key")) {
        	exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        	resEntity = ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionData);
        } else {
        	exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        	resEntity = ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionData);
        }
        
        return resEntity;
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ExceptionData> handleExpiredJwt(ExpiredJwtException ex) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionData);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionData> handleGenericException(Exception ex) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setStrMessage(ex.getMessage() + ": " + ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionData);
    }
}