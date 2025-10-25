package com.example.diemdanh.dto.request.create;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateClassRequest {
    @NotBlank(message = "Class name is required")
    @Size(max = 150, message = "Class name must not exceed 150 characters")
    @Schema(example = "Class Example")
    private String strClassName;
    
    @Nullable
    @Size(max = 500, message = "Description must not exceed 500 characters")
    @Schema(example = "Description Example")
    private String strClassDescription;
    
	
    @Schema(hidden = true)
	private LocalDateTime createdAt = LocalDateTime.now();

	public CreateClassRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateClassRequest(
			@NotBlank(message = "Class name is required") @Size(max = 100, message = "Class name must not exceed 100 characters") String strClassName,
			@Size(max = 500, message = "Description must not exceed 500 characters") String strClassDescription) {
		super();
		this.strClassName = strClassName;
		this.strClassDescription = strClassDescription;
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