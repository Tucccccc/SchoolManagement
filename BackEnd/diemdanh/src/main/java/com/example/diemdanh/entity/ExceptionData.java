package com.example.diemdanh.entity;

import java.util.Date;

public class ExceptionData {
    private Date timestamp;
    private int intStatusCode;
    private String strError;
    private String strMsg;
    private String path;
    
	public ExceptionData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionData(Date timestamp, int intStatusCode, String strError, String strMsg, String path) {
		super();
		this.timestamp = timestamp;
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getIntStatusCode() {
		return intStatusCode;
	}

	public void setIntStatusCode(int intStatusCode) {
		this.intStatusCode = intStatusCode;
	}

	public String getStrError() {
		return strError;
	}

	public void setStrError(String strError) {
		this.strError = strError;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}