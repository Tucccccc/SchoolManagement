package com.example.diemdanh.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginResponse {
    @NotBlank(message = "Username is require")
    @Size(max = 255, message = "Username must not exceed 255 characters")
	private String strUserName;
	private String strRole;
	private String strAccessToken;
	private String strRefreshToken;
	
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(
			@NotBlank(message = "Username is require") @Size(max = 255, message = "Username must not exceed 255 characters") String strUserName,
			String strRole, String strAccessToken, String strRefreshToken) {
		super();
		this.strUserName = strUserName;
		this.strRole = strRole;
		this.strAccessToken = strAccessToken;
		this.strRefreshToken = strRefreshToken;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	public String getStrAccessToken() {
		return strAccessToken;
	}

	public void setStrAccessToken(String strAccessToken) {
		this.strAccessToken = strAccessToken;
	}

	public String getStrRefreshToken() {
		return strRefreshToken;
	}

	public void setStrRefreshToken(String strRefreshToken) {
		this.strRefreshToken = strRefreshToken;
	}
}