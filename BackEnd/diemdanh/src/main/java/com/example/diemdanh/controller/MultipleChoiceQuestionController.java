package com.example.diemdanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/v1/teacher/get-mtc-question-by-id/{questionId}")
	public ResponseEntity<MultipleChoiceQuestionDTO> getMTCQuestionByID(@PathVariable Long questionId) {
		return ResponseEntity.ok(multipleChoiceQuestionService.getMTCQuestionByID(questionId));
	}
	
	@GetMapping("/v1/teacher/get-all-mtc-questions-by-ids")
	public ResponseEntity<MultipleChoiceQuestionDTO> getAllMTCQuestionByIDs(@RequestBody List<Long> lstIds) {
		return ResponseEntity.ok(multipleChoiceQuestionService.getAllMTCQuestionByID(lstIds));
	}
	
	@GetMapping("/v1/teacher/get-all-mtc-questions")
	public ResponseEntity<MultipleChoiceQuestionDTO> getAllMTCQuestion() {
		return ResponseEntity.ok(multipleChoiceQuestionService.getAllMTCQuestion());
	}
}