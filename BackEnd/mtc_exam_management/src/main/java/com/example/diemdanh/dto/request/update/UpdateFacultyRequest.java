package com.example.diemdanh.dto.request.update;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateFacultyRequest {
    @NotBlank(message = "Faculty name is required")
    @Size(max = 150, message = "Faculty name must not exceed 150 characters")
    @Schema(example = "Faculty name example")
    private String strFacultyName;
    
	@Nullable
    @Size(max = 500, message = "Description must not exceed 500 characters")
    @Schema(example = "Description Example")
    private String strFacultyDescription;

	public UpdateFacultyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UpdateFacultyRequest(
			@NotBlank(message = "Faculty name is required") @Size(max = 150, message = "Faculty name must not exceed 150 characters") String strFacultyName,
			@Size(max = 500, message = "Description must not exceed 500 characters") String strFacultyDescription) {
		super();
		this.strFacultyName = strFacultyName;
		this.strFacultyDescription = strFacultyDescription;
	}
	
	public String getStrFacultyName() {
		return strFacultyName;
	}

	public void setStrFacultyName(String strFacultyName) {
		this.strFacultyName = strFacultyName;
	}

	public String getStrFacultyDescription() {
		return strFacultyDescription;
	}

	public void setStrFacultyDescription(String strFacultyDescription) {
		this.strFacultyDescription = strFacultyDescription;
	}
}
