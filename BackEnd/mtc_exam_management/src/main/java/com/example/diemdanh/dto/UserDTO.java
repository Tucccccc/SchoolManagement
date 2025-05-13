package com.example.diemdanh.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.diemdanh.entity.Department;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.entity.Teacher;
import com.example.diemdanh.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	private String strToken;
	private String strRefreshToken;
	private String strExpirationTime;
	
	private String strUsername;
	private String strIdentityNumber;
	private String strPassword;
	private String strGender;
	private String strPhoneNumber;
	private String strFullName;
	private String strCity;
	private String strPernamentAddress;
	private String strContactAddress;
	private String strEthnic;
	private String strReligion;
	private String strNationality;
	private LocalDate dateOfBirth;
	private User user;
	
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
	
	private String strTeacherCode;
	private String strDegree;
	private String strCoopType;
	private Department department;
	private String strSprecialization;
	private Teacher teacher;
	
	private List<User> lstUser;
	
	private String strRole;
	
	private Boolean isFound;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int intStatusCode, String strError, String strMsg, String strToken, String strRefreshToken,
			String strExpirationTime, String strUsername, String strIdentityNumber, String strPassword,
			String strGender, String strPhoneNumber, String strFullName, String strCity, String strPernamentAddress,
			String strContactAddress, String strEthnic, String strReligion, String strNationality,
			LocalDate dateOfBirth, User user, String strStudentCode, String strStudentMothersName,
			LocalDate dateStudentMothersDateOfBirth, String strStudentMothersPhoneNumbers,
			String strStudentMothersProfession, String strStudentFathersName, LocalDate dateStudentFathersDateOfBirth,
			String strStudentFathersPhoneNumber, String strStudentFathersProfession, Integer intStudentYearOfAdmission,
			Student student, String strTeacherCode, String strDegree, String strCoopType, Department department,
			String strSprecialization, Teacher teacher, List<User> lstUser, String strRole, Boolean isFound) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.strToken = strToken;
		this.strRefreshToken = strRefreshToken;
		this.strExpirationTime = strExpirationTime;
		this.strUsername = strUsername;
		this.strIdentityNumber = strIdentityNumber;
		this.strPassword = strPassword;
		this.strGender = strGender;
		this.strPhoneNumber = strPhoneNumber;
		this.strFullName = strFullName;
		this.strCity = strCity;
		this.strPernamentAddress = strPernamentAddress;
		this.strContactAddress = strContactAddress;
		this.strEthnic = strEthnic;
		this.strReligion = strReligion;
		this.strNationality = strNationality;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
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
		this.strTeacherCode = strTeacherCode;
		this.strDegree = strDegree;
		this.strCoopType = strCoopType;
		this.department = department;
		this.strSprecialization = strSprecialization;
		this.teacher = teacher;
		this.lstUser = lstUser;
		this.strRole = strRole;
		this.isFound = isFound;
	}

	public String getStrTeacherCode() {
		return strTeacherCode;
	}

	public void setStrTeacherCode(String strTeacherCode) {
		this.strTeacherCode = strTeacherCode;
	}

	public String getStrDegree() {
		return strDegree;
	}

	public void setStrDegree(String strDegree) {
		this.strDegree = strDegree;
	}

	public String getStrCoopType() {
		return strCoopType;
	}

	public void setStrCoopType(String strCoopType) {
		this.strCoopType = strCoopType;
	}

	public String getStrSprecialization() {
		return strSprecialization;
	}

	public void setStrSprecialization(String strSprecialization) {
		this.strSprecialization = strSprecialization;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public LocalDate getDateStudentMothersDateOfBirth() {
		return dateStudentMothersDateOfBirth;
	}

	public void setDateStudentMothersDateOfBirth(LocalDate dateStudentMothersDateOfBirth) {
		this.dateStudentMothersDateOfBirth = dateStudentMothersDateOfBirth;
	}

	public LocalDate getDateStudentFathersDateOfBirth() {
		return dateStudentFathersDateOfBirth;
	}

	public void setDateStudentFathersDateOfBirth(LocalDate dateStudentFathersDateOfBirth) {
		this.dateStudentFathersDateOfBirth = dateStudentFathersDateOfBirth;
	}

	public Integer getIntStudentYearOfAdmission() {
		return intStudentYearOfAdmission;
	}

	public void setIntStudentYearOfAdmission(Integer intStudentYearOfAdmission) {
		this.intStudentYearOfAdmission = intStudentYearOfAdmission;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStrIdentityNumber() {
		return strIdentityNumber;
	}

	public void setStrIdentityNumber(String strIdentityNumber) {
		this.strIdentityNumber = strIdentityNumber;
	}

	public String getStrGender() {
		return strGender;
	}

	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}

	public String getStrPhoneNumber() {
		return strPhoneNumber;
	}

	public void setStrPhoneNumber(String strPhoneNumber) {
		this.strPhoneNumber = strPhoneNumber;
	}

	public String getStrFullName() {
		return strFullName;
	}

	public void setStrFullName(String strFullName) {
		this.strFullName = strFullName;
	}

	public String getStrPernamentAddress() {
		return strPernamentAddress;
	}

	public void setStrPernamentAddress(String strPernamentAddress) {
		this.strPernamentAddress = strPernamentAddress;
	}

	public String getStrContactAddress() {
		return strContactAddress;
	}

	public void setStrContactAddress(String strContactAddress) {
		this.strContactAddress = strContactAddress;
	}

	public String getStrEthnic() {
		return strEthnic;
	}

	public void setStrEthnic(String strEthnic) {
		this.strEthnic = strEthnic;
	}

	public String getStrReligion() {
		return strReligion;
	}

	public void setStrReligion(String strReligion) {
		this.strReligion = strReligion;
	}

	public String getStrNationality() {
		return strNationality;
	}

	public void setStrNationality(String strNationality) {
		this.strNationality = strNationality;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getStrToken() {
		return strToken;
	}

	public void setStrToken(String strToken) {
		this.strToken = strToken;
	}

	public String getStrRefreshToken() {
		return strRefreshToken;
	}

	public void setStrRefreshToken(String strRefreshToken) {
		this.strRefreshToken = strRefreshToken;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrUsername() {
		return strUsername;
	}

	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}

	public String getStrExpirationTime() {
		return strExpirationTime;
	}

	public void setStrExpirationTime(String strExpirationTime) {
		this.strExpirationTime = strExpirationTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLstUser() {
		return lstUser;
	}

	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	public String getStrCity() {
		return strCity;
	}

	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}
}