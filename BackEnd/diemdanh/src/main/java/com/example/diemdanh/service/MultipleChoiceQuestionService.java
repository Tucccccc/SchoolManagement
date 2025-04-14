package com.example.diemdanh.service;

import com.example.diemdanh.dto.MultipleChoiceQuestionDTO;

public interface MultipleChoiceQuestionService {
	// * Add Question
	// Input: MultipleChoiceQuestionDTO multipleChoiceQuestionRequest
	// Output: MultipleChoiceQuestionDTO multipleChoiceQuestionDTO
	// Giang Ngo Truong 08/04/2025
	MultipleChoiceQuestionDTO addQuestion(MultipleChoiceQuestionDTO multipleChoiceQuestionRequest);
	
	// * Get Question by ID
	// Input: Long id
	// Output: MultipleChoiceQuestionDTO multipleChoiceQuestionDTO
	// Giang Ngo Truong 14/04/2025
	MultipleChoiceQuestionDTO getMTCQuestionByID(Long id);
}
