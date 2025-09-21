package com.example.diemdanh.config.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InternalServerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}