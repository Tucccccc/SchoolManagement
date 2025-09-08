package com.example.diemdanh.service;

import com.example.diemdanh.dto.ExamDTO;

public interface ExamService {
	// * Add Exam
	// Input: ExamDTO examRequest
	// Output: ExamDTO examDTO
	// Giang Ngo Truong 04/05/2025
	ExamDTO addExam(ExamDTO examRequest);
	
	// * Get Exam By ID
	// Input: ExamDTO examRequest
	// Output: ExamDTO examDTO
	// Giang Ngo Truong 05/08/2025
	ExamDTO getExamByID(int id);
	
	// * Get ALL Exam
	// Input: 
	// Output: ExamDTO examDTO
	// Giang Ngo Truong 05/08/2025
	ExamDTO getAllExam();
}
