package com.example.diemdanh.dto;

public class LogoutRequest {
	private String username;

	public LogoutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogoutRequest(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}