package com.example.diemdanh.dto.request.update;

import com.example.diemdanh.dto.dtoenum.ClassStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateClassRequest {
    @NotBlank(message = "Class name is required")
    @Size(max = 150, message = "Class name must not exceed 150 characters")
    @Schema(example = "Class Example")
    private String strClassName;
    
    @Size(max = 500, message = "Description must not exceed 500 characters")
    @Schema(example = "Description Example")
    private String strClassDescription;

    @Enumerated(EnumType.STRING)
    @Schema(example = "ACTIVE")
    private ClassStatus status;

	public UpdateClassRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateClassRequest(
			@NotBlank(message = "Class name is required") @Size(max = 150, message = "Class name must not exceed 150 characters") String strClassName,
			@Size(max = 500, message = "Description must not exceed 500 characters") String strClassDescription,
			ClassStatus status) {
		super();
		this.strClassName = strClassName;
		this.strClassDescription = strClassDescription;
		this.status = status;
	}

	public ClassStatus getStatus() {
		return status;
	}

	public void setStatus(ClassStatus status) {
		this.status = status;
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
}
