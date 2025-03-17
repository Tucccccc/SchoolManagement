package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.ClassDTO;
import com.example.diemdanh.service.ClassService;

@RestController
public class ClassController {
	@Autowired
	private ClassService classService;
	
	@PostMapping("/v1/admin/add-class")
	public ResponseEntity<ClassDTO> addClass(@RequestBody ClassDTO req) {
		return ResponseEntity.ok(classService.addClass(req));
	}
	
	@GetMapping("/v1/admin/get-all-class")
	public ResponseEntity<ClassDTO> getAllClass() {
		return ResponseEntity.ok(classService.getAllClass());
	}
}
