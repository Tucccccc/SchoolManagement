package com.example.diemdanh.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String className;
	private String classDescription;
	
	@OneToMany(mappedBy = "homeRoomClass", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonManagedReference
	private Set<Student> students;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassEntity(Long id, String className, String classDescription, Set<Student> students,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.className = className;
		this.classDescription = classDescription;
		this.students = students;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
}