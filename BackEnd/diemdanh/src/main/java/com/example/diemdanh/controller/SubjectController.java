package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.SubjectDTO;
import com.example.diemdanh.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/v1/admin/add-subject")
	public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectRequest) {
		return ResponseEntity.ok(subjectService.addSubject(subjectRequest));
	}
}
