package com.example.diemdanh.exception.types;

/**
 * Exception thrown when an invalid operation is attempted
 */
public class InvalidOperationException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public InvalidOperationException(String message) {
        super(message);
    }
    
    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}