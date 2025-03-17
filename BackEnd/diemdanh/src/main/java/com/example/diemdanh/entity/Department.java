package com.example.diemdanh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	private Long id;
	
	private String departmentName;
	
	@ManyToOne
	private Faculty faculty;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, String departmentName, Faculty facultyId) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.faculty = facultyId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty facultyId) {
		this.faculty = facultyId;
	}
}