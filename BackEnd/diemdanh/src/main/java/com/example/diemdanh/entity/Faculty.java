package com.example.diemdanh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	private Long id;
	
	private String facultyName;

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(Long id, String facultyName) {
		super();
		this.id = id;
		this.facultyName = facultyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
}