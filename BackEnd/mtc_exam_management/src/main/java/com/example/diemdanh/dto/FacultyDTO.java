package com.example.diemdanh.dto;

public class FacultyDTO {
	private String strFacultyName;
	private String strFacultyDescription;
	
	public FacultyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyDTO(String strFacultyName, String strFacultyDescription) {
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
