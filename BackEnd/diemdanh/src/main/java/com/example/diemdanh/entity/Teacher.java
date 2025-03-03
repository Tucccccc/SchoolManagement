package com.example.diemdanh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    private Long id; // Khóa ngoại từ bảng users

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(unique = true, nullable = false)
    private String teacherCode;

    private String degree;
    private String coopType;
    private String department;
    private String specialization;
    
	public Teacher(Long id, User user, String teacherCode, String degree, String coopType, String department,
			String specialization) {
		super();
		this.id = id;
		this.user = user;
		this.teacherCode = teacherCode;
		this.degree = degree;
		this.coopType = coopType;
		this.department = department;
		this.specialization = specialization;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCoopType() {
		return coopType;
	}

	public void setCoopType(String coopType) {
		this.coopType = coopType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}