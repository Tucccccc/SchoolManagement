package com.example.diemdanh.service;

import com.example.diemdanh.dto.FacultyDTO;

public interface FacultyService {
	// * addFaculty
	// Input: FacultyDTO facultyRequest
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	FacultyDTO addFaculty(FacultyDTO facultyRequest);
	
	// * getAllFaculty
	// Input: 
	// Output: FacultyDTO
	// Giang Ngo Truong 25/03/2025
	FacultyDTO getAllFaculty();
}
