package com.example.diemdanh.dto.response;

import java.time.LocalDateTime;

import com.example.diemdanh.dto.dtoenum.ClassStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClassResponse {
	private Long id;
	
    @NotBlank(message = "Class name is required")
    @Size(max = 150, message = "Class name must not exceed 150 characters")
	private String className;
    @Size(max = 500, message = "Description must not exceed 500 characters")
	private String classDescription;
	
	private ClassStatus status;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ClassResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassResponse(Long id,
			@NotBlank(message = "Class name is required") @Size(max = 100, message = "Class name must not exceed 100 characters") String className,
			String classDescription, ClassStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.className = className;
		this.classDescription = classDescription;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ClassStatus getStatus() {
		return status;
	}

	public void setStatus(ClassStatus status) {
		this.status = status;
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