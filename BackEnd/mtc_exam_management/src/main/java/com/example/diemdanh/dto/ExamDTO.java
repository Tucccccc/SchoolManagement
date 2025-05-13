package com.example.diemdanh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamDTO {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	
	private String strTitle;
	private int intDuration;
	
	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamDTO(int intStatusCode, String strError, String strMsg, String strTitle, int intDuration) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.strTitle = strTitle;
		this.intDuration = intDuration;
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

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public int getIntDuration() {
		return intDuration;
	}

	public void setIntDuration(int intDuration) {
		this.intDuration = intDuration;
	}
}