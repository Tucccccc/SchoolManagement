package com.example.diemdanh.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {
    @NotBlank(message = "Username is require")
    @Size(max = 255, message = "Username must not exceed 255 characters")
    @Schema(example = "Username Example")
	private String strUserName;
    
    @NotBlank(message = "Password is require")
    @Size(max = 255, message = "Password must not exceed 255 characters")
    @Schema(example = "Username Example")
	private String strPassword;
	
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(
			@NotBlank(message = "Username is require") @Size(max = 255, message = "Username must not exceed 255 characters") String strUserName,
			@NotBlank(message = "Password is require") @Size(max = 255, message = "Password must not exceed 255 characters") String strPassword) {
		super();
		this.strUserName = strUserName;
		this.strPassword = strPassword;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
}