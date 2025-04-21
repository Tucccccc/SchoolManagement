package com.example.diemdanh.entity;

import java.util.Date;

public class ExceptionData {
    private Date timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;

    public ExceptionData() {
        super();
    }

    public ExceptionData(String message) {
        super();
        this.message = message;
    }

    public ExceptionData(Date timestamp, int statusCode, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
