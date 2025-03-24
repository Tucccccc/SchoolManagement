package com.example.diemdanh.dto;

import java.util.List;

import com.example.diemdanh.entity.Faculty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacultyDTO {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	
	private Long longFacultyId;
	private String strFacultyName;
	private String strFacultyDescription;
	
	private Faculty faculty;
	
	private List<Faculty> lstFaculty;
	
	public FacultyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyDTO(int intStatusCode, String strError, String strMsg, Long longFacultyId, String strFacultyName,
			String strFacultyDescription, Faculty faculty, List<Faculty> lstFaculty) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.longFacultyId = longFacultyId;
		this.strFacultyName = strFacultyName;
		this.strFacultyDescription = strFacultyDescription;
		this.faculty = faculty;
		this.lstFaculty = lstFaculty;
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

	public Long getLongFacultyId() {
		return longFacultyId;
	}

	public void setLongFacultyId(Long longFacultyId) {
		this.longFacultyId = longFacultyId;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Faculty> getLstFaculty() {
		return lstFaculty;
	}

	public void setLstFaculty(List<Faculty> lstFaculty) {
		this.lstFaculty = lstFaculty;
	}
}