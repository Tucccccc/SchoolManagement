package com.example.diemdanh.service;

import org.springframework.stereotype.Repository;

import com.example.diemdanh.dto.StudentDTO;

@Repository
public interface StudentService {
	// * getAllStudent
	// Input:
	// Output: StudentDTO studentResp
	// Giang Ngo Truong 20/03/2025
	StudentDTO getAllStudent();
	
	// * getStudentByID
	// Input: Id
	// Output: StudentDTO studentResp
	// Giang Ngo Truong 24/03/2025
	StudentDTO getStudentByID(Long Id);
}