package com.example.diemdanh.service;

import java.util.List;

import com.example.diemdanh.dto.request.create.CreateClassRequest;
import com.example.diemdanh.dto.request.update.UpdateClassRequest;
import com.example.diemdanh.dto.response.ClassResponse;

public interface ClassService {
	// * Add Class
	// Input: CreateClassRequest addClass
	// Output: ResponseData<ClassResponse> ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassResponse addClass(CreateClassRequest createClassRequest);
	
	// * Get all Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	List<ClassResponse> getAllClass();
	
	// * Get Class by ID
	// Input: Long Id
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassResponse getClassById(Long Id);
	
	// * Update Class
	// Input: UpdateClassRequest addClass
	// Output: ResponseData<ClassResponse> classDTO
	// Giang Ngo Truong 18/09/2025
	ClassResponse updateClass(Long id, UpdateClassRequest updateClassRequest);
	
	// * Delete Class by ID
	// Input: Long Id
	// Output: ResponseData<ClassResponse>
	// Giang Ngo Truong 18/09/2025
	ClassResponse deleteClassById(Long id);
	
	// * assignStudentToClass
	// Input: List<Long> Id
	// Output: Boolean isSuccess
	// Giang Ngo Truong 17/03/2025
	void assignStudentToClass(List<Long> lstIdStudent, Long classId);
}