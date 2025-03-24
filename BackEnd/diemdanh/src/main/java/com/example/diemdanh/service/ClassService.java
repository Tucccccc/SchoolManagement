package com.example.diemdanh.service;

import com.example.diemdanh.dto.ClassDTO;

public interface ClassService {
	// * Add Class
	// Input: ClassDTO addClass
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassDTO addClass(ClassDTO classRequest);
	
	// * Get all Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassDTO getAllClass();
	
	// * Get Class by ID
	// Input: Long Id
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassDTO getClassById(Long Id);
}
