package com.example.demo.dto.response;

import java.time.LocalDateTime;

public class ClassResponse {
	private String className;
	private String classDescription;
	
	private Boolean isFound;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ClassResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassResponse(String className, String classDescription, Boolean isFound, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.className = className;
		this.classDescription = classDescription;
		this.isFound = isFound;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public ClassResponse(String className, String classDescription) {
		super();
		this.className = className;
		this.classDescription = classDescription;
	}

	public ClassResponse(String className, String classDescription, Boolean isFound) {
		super();
		this.className = className;
		this.classDescription = classDescription;
		this.isFound = isFound;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}