package com.example.diemdanh.dto;

import java.util.List;
import java.util.Set;

import com.example.diemdanh.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqResUser {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	private String strToken;
	private String strRefreshToken;
	private String strPassword;
	private String strUsername;
	private String strExpirationTime;
	private User user;
	private List<User> lstUser;
	private Set<String> strRoles;

	public ReqResUser(int intStatusCode, String strError, String strMsg, String strToken, String strRefreshToken,
			String strPassword, String strUsername, String strExpirationTime, User user, List<User> lstUser,
			Set<String> strRoles) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.strToken = strToken;
		this.strRefreshToken = strRefreshToken;
		this.strPassword = strPassword;
		this.strUsername = strUsername;
		this.strExpirationTime = strExpirationTime;
		this.user = user;
		this.lstUser = lstUser;
		this.strRoles = strRoles;
	}

	public ReqResUser() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getStrToken() {
		return strToken;
	}

	public void setStrToken(String strToken) {
		this.strToken = strToken;
	}

	public String getStrRefreshToken() {
		return strRefreshToken;
	}

	public void setStrRefreshToken(String strRefreshToken) {
		this.strRefreshToken = strRefreshToken;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrUsername() {
		return strUsername;
	}

	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLstUser() {
		return lstUser;
	}

	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public String getStrExpirationTime() {
		return strExpirationTime;
	}

	public void setStrExpirationTime(String strExpirationTime) {
		this.strExpirationTime = strExpirationTime;
	}

	public Set<String> getStrRoles() {
		return strRoles;
	}

	public void setStrRoles(Set<String> strRoles) {
		this.strRoles = strRoles;
	}
}