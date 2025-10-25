package com.example.diemdanh.dto;

import java.time.LocalDateTime;

import com.example.diemdanh.dto.dtoenum.EnumResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
	private EnumResponseStatus status;
	private String message;
	private LocalDateTime timestamp;
	private T data;
	private Object meta; // For pagination or additional metadata
	
    public ResponseData() {
        this.timestamp = LocalDateTime.now();
    }
	public ResponseData(EnumResponseStatus status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();;
		this.data = data;
	}

	public ResponseData(EnumResponseStatus status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ResponseData(String message, T data, Object meta) {
		super();
		this.message = message;
		this.data = data;
		this.meta = meta;
	}
	public EnumResponseStatus getStatus() {
		return status;
	}

	public void setStatus(EnumResponseStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setData(T data) {
		this.data = data;
	}

    public Object getMeta() {
		return meta;
	}
	public void setMeta(Object meta) {
		this.meta = meta;
	}
	public static <T> ResponseData<T> of(EnumResponseStatus status, String message, T data) {
        return new ResponseData<>(status, message, data);
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(EnumResponseStatus.SUCCESS, EnumResponseStatus.SUCCESS.getDefaultMessage(), data);
    }

    public static <T> ResponseData<T> error(String message, T data) {
        return new ResponseData<>(EnumResponseStatus.ERROR, message, data);
    }

    public static <T> ResponseData<T> notFound(String message) {
        return new ResponseData<>(EnumResponseStatus.NOT_FOUND, message, null);
    }
}