package com.example.diemdanh.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.diemdanh.dto.dtoenum.ClassStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "class")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "class_name", nullable = false, length = 150)
	private String className;
	
    @Column(name = "description", length = 500)
	private String classDescription;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClassStatus status = ClassStatus.ACTIVE;
	
	@OneToMany(mappedBy = "homeRoomClass", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonManagedReference
	private Set<Student> students;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassEntity(Long id,
			@NotBlank(message = "Class name is required") @Size(max = 150, message = "Class name must not exceed 150 characters") String className,
			@Size(max = 500, message = "Description must not exceed 500 characters") String classDescription,
			ClassStatus status, Set<Student> students, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.className = className;
		this.classDescription = classDescription;
		this.status = status;
		this.students = students;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public ClassEntity(Long id,
			@NotBlank(message = "Class name is required") @Size(max = 150, message = "Class name must not exceed 150 characters") String className,
			@Size(max = 500, message = "Description must not exceed 500 characters") String classDescription,
			ClassStatus status, Set<Student> students) {
		super();
		this.id = id;
		this.className = className;
		this.classDescription = classDescription;
		this.status = status;
		this.students = students;
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

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public ClassStatus getStatus() {
		return status;
	}

	public void setStatus(ClassStatus status) {
		this.status = status;
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
}