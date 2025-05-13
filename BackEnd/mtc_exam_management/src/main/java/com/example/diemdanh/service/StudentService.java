package com.example.diemdanh.service;

import com.example.diemdanh.dto.StudentDTO;

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
	
	// * getStudentWithoutClass
	// Input: 
	// Output: StudentDTO studentResp
	// Giang Ngo Truong 01/04/2025
	StudentDTO getStudentWithoutClass();
}