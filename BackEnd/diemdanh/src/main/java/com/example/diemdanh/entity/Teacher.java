package com.example.diemdanh.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @ManyToOne
    private Department department;

    @Column(unique = true, nullable = false)
    private String teacherCode;

    private String degree;
    private String coopType;
    private String specialization;
    
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Long id, User user, Department department, String teacherCode, String degree, String coopType,
			String specialization, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.department = department;
		this.teacherCode = teacherCode;
		this.degree = degree;
		this.coopType = coopType;
		this.specialization = specialization;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department departmentId) {
		this.department = departmentId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}