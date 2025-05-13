package com.example.diemdanh.dto;

import java.util.List;

import com.example.diemdanh.entity.Subject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDTO {
	private int intStatusCode;
	private String strMsg;
	
	private String strSubjectName;
	private String strSubjectDescription;
	
	private Subject subject;
	private List<Subject> lstSubject;
	
	private DepartmentDTO departmentDTO;

	public SubjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectDTO(int intStatusCode, String strMsg, String strSubjectName, String strSubjectDescription,
			Subject subject, List<Subject> lstSubject, DepartmentDTO departmentDTO) {
		super();
		this.intStatusCode = intStatusCode;
		this.strMsg = strMsg;
		this.strSubjectName = strSubjectName;
		this.strSubjectDescription = strSubjectDescription;
		this.subject = subject;
		this.lstSubject = lstSubject;
		this.departmentDTO = departmentDTO;
	}

	public int getIntStatusCode() {
		return intStatusCode;
	}

	public void setIntStatusCode(int intStatusCode) {
		this.intStatusCode = intStatusCode;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public String getStrSubjectName() {
		return strSubjectName;
	}

	public void setStrSubjectName(String strSubjectName) {
		this.strSubjectName = strSubjectName;
	}

	public String getStrSubjectDescription() {
		return strSubjectDescription;
	}

	public void setStrSubjectDescription(String strSubjectDescription) {
		this.strSubjectDescription = strSubjectDescription;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Subject> getLstSubject() {
		return lstSubject;
	}

	public void setLstSubject(List<Subject> lstSubject) {
		this.lstSubject = lstSubject;
	}

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
}