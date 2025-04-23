package com.example.diemdanh.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.diemdanh.entity.ExceptionData;
import com.example.diemdanh.exception.types.BadRequestException;
import com.example.diemdanh.exception.types.DuplicateResourceException;
import com.example.diemdanh.exception.types.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionData> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "Resource Not Found",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionData> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Bad Request",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ExceptionData> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "Unauthorized",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ExceptionData> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "Bad Credentials",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ExceptionData> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.FORBIDDEN.value(),
                ex.getMessage(),
                "Access Denied",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existing, replacement) -> existing + ", " + replacement
                ));
        
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", errors);
        response.put("message", "Validation failed");
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ExceptionData> handleDuplicateResourceException(DuplicateResourceException ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                "Duplicate Resource",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionData> handleGlobalException(Exception ex, WebRequest request) {
        ExceptionData errorDetails = new ExceptionData(
        		new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                "Global Exception",
                request.getDescription(false).toString());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}