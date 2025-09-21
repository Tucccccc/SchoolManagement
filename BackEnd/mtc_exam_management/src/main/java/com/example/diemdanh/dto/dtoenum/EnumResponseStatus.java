package com.example.diemdanh.dto.dtoenum;

import org.springframework.http.HttpStatus;

public enum EnumResponseStatus {
	SUCCESS(HttpStatus.OK, "Success"), 
	ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Error"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "Not found"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
	FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request");
	
    private final HttpStatus httpStatus;
    private final String defaultMessage;

    EnumResponseStatus(HttpStatus httpStatus, String defaultMessage) {
		this.httpStatus = httpStatus;
		this.defaultMessage = defaultMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
}