package com.example.diemdanh.global.constant;

/**
 * Global constants for the application
 */
public class GlobalConstant {
    // Roles
    public static final String STR_STUDENT_ROLE = "STUDENT";
    public static final String STR_TEACHER_ROLE = "TEACHER";
    public static final String STR_ADMIN_ROLE = "ADMIN";
    public static final String STR_USER_ROLE = "USER";
    
    // JWT Constants
    public static final long JWT_EXPIRATION = 24 * 60 * 60 * 1000; // 24 hours
    public static final long REFRESH_EXPIRATION = 7 * 24 * 60 * 60 * 1000; // 7 days
    
    // Security messages
    public static final String TOKEN_EXPIRED_MESSAGE = "Token has expired. Please log in again";
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid username or password";
    public static final String ACCESS_DENIED_MESSAGE = "You don't have permission to access this resource";
    
    // Error messages
    public static final String CONSTRAINT_VIOLATION_MESSAGE = "Validation failed. Please check your input";
    public static final String DATA_INTEGRITY_VIOLATION_MESSAGE = "Database constraint violated. The operation cannot be completed";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "An unexpected error occurred. Please try again later";
    
    // Success messages
    public static final String OPERATION_SUCCESS_MESSAGE = "Operation completed successfully";
    
    // Pagination defaults
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String DEFAULT_SORT_DIRECTION = "DESC";
}