package com.example.demo.dto.response;

public enum EnumResponseStatus {
	SUCCESS("Success"), 
	ERROR("Error");
	
    private final String message;

    EnumResponseStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
