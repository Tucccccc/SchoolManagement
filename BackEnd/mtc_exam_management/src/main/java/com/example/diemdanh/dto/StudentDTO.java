package com.example.diemdanh.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.diemdanh.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	
	private String strStudentCode;
	private String strStudentMothersName;
	private LocalDate dateStudentMothersDateOfBirth;
	private String strStudentMothersPhoneNumbers;
	private String strStudentMothersProfession;
	private String strStudentFathersName;
	private LocalDate dateStudentFathersDateOfBirth;
	private String strStudentFathersPhoneNumber;
	private String strStudentFathersProfession;
	private Integer intStudentYearOfAdmission;
	private Student student;
	
	private List<Student> lstStudent;
	
	private Boolean isFound;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(int intStatusCode, String strError, String strMsg, String strStudentCode,
			String strStudentMothersName, LocalDate dateStudentMothersDateOfBirth, String strStudentMothersPhoneNumbers,
			String strStudentMothersProfession, String strStudentFathersName, LocalDate dateStudentFathersDateOfBirth,
			String strStudentFathersPhoneNumber, String strStudentFathersProfession, Integer intStudentYearOfAdmission,
			Student student, List<Student> lstStudent, Boolean isFound) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.strStudentCode = strStudentCode;
		this.strStudentMothersName = strStudentMothersName;
		this.dateStudentMothersDateOfBirth = dateStudentMothersDateOfBirth;
		this.strStudentMothersPhoneNumbers = strStudentMothersPhoneNumbers;
		this.strStudentMothersProfession = strStudentMothersProfession;
		this.strStudentFathersName = strStudentFathersName;
		this.dateStudentFathersDateOfBirth = dateStudentFathersDateOfBirth;
		this.strStudentFathersPhoneNumber = strStudentFathersPhoneNumber;
		this.strStudentFathersProfession = strStudentFathersProfession;
		this.intStudentYearOfAdmission = intStudentYearOfAdmission;
		this.student = student;
		this.lstStudent = lstStudent;
		this.isFound = isFound;
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

	public String getStrStudentCode() {
		return strStudentCode;
	}

	public void setStrStudentCode(String strStudentCode) {
		this.strStudentCode = strStudentCode;
	}

	public String getStrStudentMothersName() {
		return strStudentMothersName;
	}

	public void setStrStudentMothersName(String strStudentMothersName) {
		this.strStudentMothersName = strStudentMothersName;
	}

	public LocalDate getDateStudentMothersDateOfBirth() {
		return dateStudentMothersDateOfBirth;
	}

	public void setDateStudentMothersDateOfBirth(LocalDate dateStudentMothersDateOfBirth) {
		this.dateStudentMothersDateOfBirth = dateStudentMothersDateOfBirth;
	}

	public String getStrStudentMothersPhoneNumbers() {
		return strStudentMothersPhoneNumbers;
	}

	public void setStrStudentMothersPhoneNumbers(String strStudentMothersPhoneNumbers) {
		this.strStudentMothersPhoneNumbers = strStudentMothersPhoneNumbers;
	}

	public String getStrStudentMothersProfession() {
		return strStudentMothersProfession;
	}

	public void setStrStudentMothersProfession(String strStudentMothersProfession) {
		this.strStudentMothersProfession = strStudentMothersProfession;
	}

	public String getStrStudentFathersName() {
		return strStudentFathersName;
	}

	public void setStrStudentFathersName(String strStudentFathersName) {
		this.strStudentFathersName = strStudentFathersName;
	}

	public LocalDate getDateStudentFathersDateOfBirth() {
		return dateStudentFathersDateOfBirth;
	}

	public void setDateStudentFathersDateOfBirth(LocalDate dateStudentFathersDateOfBirth) {
		this.dateStudentFathersDateOfBirth = dateStudentFathersDateOfBirth;
	}

	public String getStrStudentFathersPhoneNumber() {
		return strStudentFathersPhoneNumber;
	}

	public void setStrStudentFathersPhoneNumber(String strStudentFathersPhoneNumber) {
		this.strStudentFathersPhoneNumber = strStudentFathersPhoneNumber;
	}

	public String getStrStudentFathersProfession() {
		return strStudentFathersProfession;
	}

	public void setStrStudentFathersProfession(String strStudentFathersProfession) {
		this.strStudentFathersProfession = strStudentFathersProfession;
	}

	public Integer getIntStudentYearOfAdmission() {
		return intStudentYearOfAdmission;
	}

	public void setIntStudentYearOfAdmission(Integer intStudentYearOfAdmission) {
		this.intStudentYearOfAdmission = intStudentYearOfAdmission;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getLstStudent() {
		return lstStudent;
	}

	public void setLstStudent(List<Student> lstStudent) {
		this.lstStudent = lstStudent;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}
}