package com.example.demo.dto.request;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassRequest {
	private String strClassName;
	private String strClassDescription;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public ClassRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassRequest(String strClassName, String strClassDescription, LocalDateTime createdAt) {
		super();
		this.strClassName = strClassName;
		this.strClassDescription = strClassDescription;
		this.createdAt = createdAt;
	}

	public String getStrClassName() {
		return strClassName;
	}

	public void setStrClassName(String strClassName) {
		this.strClassName = strClassName;
	}

	public String getStrClassDescription() {
		return strClassDescription;
	}

	public void setStrClassDescription(String strClassDescription) {
		this.strClassDescription = strClassDescription;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}