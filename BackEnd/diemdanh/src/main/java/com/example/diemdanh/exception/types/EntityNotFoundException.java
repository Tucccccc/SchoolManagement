package com.example.diemdanh.exception.types;

/**
 * Exception thrown when an entity is not found in the database
 */
public class EntityNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s with id %d not found", entityName, id));
    }
    
    public EntityNotFoundException(String entityName, String identifier) {
        super(String.format("%s with identifier %s not found", entityName, identifier));
    }
    
    public EntityNotFoundException(String message) {
        super(message);
    }
}