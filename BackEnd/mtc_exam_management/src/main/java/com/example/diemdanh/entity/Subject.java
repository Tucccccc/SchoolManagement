package com.example.diemdanh.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subjectName;
	private String subjectDescription;
	
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt = new Date();
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Long id, String subjectName, String subjectDescription, Department department, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.department = department;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}