package com.example.diemdanh.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long id; // Khóa ngoại từ bảng users

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(unique = true, nullable = false)
    private String studentCode;
    
    private String mothersName;
    private LocalDate mothersDateOfBirth;
    private String mothersPhoneNumber;
    private String mothersProfession;
    
    private String fathersName;
    private LocalDate fathersDateOfBirth;
    private String fathersPhoneNumber;
    private String fathersProfession;
    
    private Integer intYearOfAdmission;

	public Student(Long id, User user, String studentCode, String mothersName, LocalDate mothersDateOfBirth,
			String mothersPhoneNumber, String mothersProfession, String fathersName, LocalDate fathersDateOfBirth,
			String fathersPhoneNumber, String fathersProfession, Integer intYearOfAdmission) {
		super();
		this.id = id;
		this.user = user;
		this.studentCode = studentCode;
		this.mothersName = mothersName;
		this.mothersDateOfBirth = mothersDateOfBirth;
		this.mothersPhoneNumber = mothersPhoneNumber;
		this.mothersProfession = mothersProfession;
		this.fathersName = fathersName;
		this.fathersDateOfBirth = fathersDateOfBirth;
		this.fathersPhoneNumber = fathersPhoneNumber;
		this.fathersProfession = fathersProfession;
		this.intYearOfAdmission = intYearOfAdmission;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIntYearOfAdmission() {
		return intYearOfAdmission;
	}

	public void setIntYearOfAdmission(Integer intYearOfAdmission) {
		this.intYearOfAdmission = intYearOfAdmission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public LocalDate getMothersDateOfBirth() {
		return mothersDateOfBirth;
	}

	public void setMothersDateOfBirth(LocalDate mothersDateOfBirth) {
		this.mothersDateOfBirth = mothersDateOfBirth;
	}

	public String getMothersPhoneNumber() {
		return mothersPhoneNumber;
	}

	public void setMothersPhoneNumber(String mothersPhoneNumber) {
		this.mothersPhoneNumber = mothersPhoneNumber;
	}

	public String getMothersProfession() {
		return mothersProfession;
	}

	public void setMothersProfession(String mothersProfession) {
		this.mothersProfession = mothersProfession;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public LocalDate getFathersDateOfBirth() {
		return fathersDateOfBirth;
	}

	public void setFathersDateOfBirth(LocalDate fathersDateOfBirth) {
		this.fathersDateOfBirth = fathersDateOfBirth;
	}

	public String getFathersPhoneNumber() {
		return fathersPhoneNumber;
	}

	public void setFathersPhoneNumber(String fathersPhoneNumber) {
		this.fathersPhoneNumber = fathersPhoneNumber;
	}

	public String getFathersProfession() {
		return fathersProfession;
	}

	public void setFathersProfession(String fathersProfession) {
		this.fathersProfession = fathersProfession;
	}
}