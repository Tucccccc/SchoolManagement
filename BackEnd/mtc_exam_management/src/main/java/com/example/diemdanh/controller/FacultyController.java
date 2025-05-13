package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.FacultyDTO;
import com.example.diemdanh.service.FacultyService;

@RestController
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	
	@PostMapping("/v1/admin/add-faculty")
	public ResponseEntity<FacultyDTO> addFaculty(@RequestBody FacultyDTO req) {
		return ResponseEntity.ok(facultyService.addFaculty(req));
	}
	
	@GetMapping("/v1/admin/get-all-faculty")
	public ResponseEntity<FacultyDTO> getAllFaculty() {
		return ResponseEntity.ok(facultyService.getAllFaculty());
	}
}