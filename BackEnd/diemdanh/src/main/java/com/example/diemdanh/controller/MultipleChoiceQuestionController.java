package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.MultipleChoiceQuestionDTO;
import com.example.diemdanh.service.MultipleChoiceQuestionService;

@RestController
public class MultipleChoiceQuestionController {
	@Autowired
	private MultipleChoiceQuestionService multipleChoiceQuestionService;
	
	@PostMapping("/v1/teacher/add-question")
	public ResponseEntity<MultipleChoiceQuestionDTO> addQuestion(@RequestBody MultipleChoiceQuestionDTO multipleChoiceQuestionRequest) {
		return ResponseEntity.ok(multipleChoiceQuestionService.addQuestion(multipleChoiceQuestionRequest));
	}
}