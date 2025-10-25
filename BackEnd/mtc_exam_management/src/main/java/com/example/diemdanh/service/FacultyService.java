package com.example.diemdanh.service;

import java.util.List;

import com.example.diemdanh.dto.request.create.CreateFacultyRequest;
import com.example.diemdanh.dto.response.FacultyResponse;

public interface FacultyService {
	// * addFaculty
	// Input: FacultyDTO facultyRequest
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	FacultyResponse addFaculty(CreateFacultyRequest facultyRequest);
	
	// * getAllFaculty
	// Input: 
	// Output: FacultyDTO
	// Giang Ngo Truong 25/03/2025
	List<FacultyResponse> getAllFaculty();
}
