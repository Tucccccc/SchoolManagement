package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.StudentDTO;
import com.example.diemdanh.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/v1/admin/get-all-student")
	public ResponseEntity<StudentDTO> getAllStudent() {
		return ResponseEntity.ok(studentService.getAllStudent());
	}
	
	@GetMapping("v1/admin/get-student-without-class")
	public ResponseEntity<StudentDTO> getStudentWithoutClass(){
		return ResponseEntity.ok(studentService.getStudentWithoutClass());
	}
}
