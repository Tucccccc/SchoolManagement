package com.example.diemdanh.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDTO {
	private int intStatusCode;
	private String strDepartmentName;
	private String strDepartmentDescription;
	
	private FacultyDTO facultyDTO;
	
	private List<SubjectDTO> lstSubjectDTO;

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDTO(int intStatusCode, String strDepartmentName, String strDepartmentDescription,
			FacultyDTO facultyDTO, List<SubjectDTO> lstSubjectDTO) {
		super();
		this.intStatusCode = intStatusCode;
		this.strDepartmentName = strDepartmentName;
		this.strDepartmentDescription = strDepartmentDescription;
		this.facultyDTO = facultyDTO;
		this.lstSubjectDTO = lstSubjectDTO;
	}

	public int getIntStatusCode() {
		return intStatusCode;
	}

	public void setIntStatusCode(int intStatusCode) {
		this.intStatusCode = intStatusCode;
	}

	public String getStrDepartmentName() {
		return strDepartmentName;
	}

	public void setStrDepartmentName(String strDepartmentName) {
		this.strDepartmentName = strDepartmentName;
	}

	public String getStrDepartmentDescription() {
		return strDepartmentDescription;
	}

	public void setStrDepartmentDescription(String strDepartmentDescription) {
		this.strDepartmentDescription = strDepartmentDescription;
	}

	public FacultyDTO getFacultyDTO() {
		return facultyDTO;
	}

	public void setFacultyDTO(FacultyDTO facultyDTO) {
		this.facultyDTO = facultyDTO;
	}

	public List<SubjectDTO> getLstSubjectDTO() {
		return lstSubjectDTO;
	}

	public void setLstSubjectDTO(List<SubjectDTO> lstSubjectDTO) {
		this.lstSubjectDTO = lstSubjectDTO;
	}
}