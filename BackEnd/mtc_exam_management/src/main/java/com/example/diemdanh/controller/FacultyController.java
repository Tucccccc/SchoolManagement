package com.example.diemdanh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.ResponseData;
import com.example.diemdanh.dto.request.create.CreateFacultyRequest;
import com.example.diemdanh.dto.response.FacultyResponse;
import com.example.diemdanh.service.FacultyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("faculty")
@Tag(name = "Faculty Management", description = "APIs for managing Faculty")
public class FacultyController {
	private final FacultyService facultyService;

	
	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@PostMapping("/v1/admin-principal/add-faculty")
	@PreAuthorize("hasRole('ADMIN') or hasRole('PRINCIPAL')")
	@Operation(summary = "Add Faculty", description = "Save Faculty to Database require ADMIN or PRINCIPAL")
	public ResponseEntity<ResponseData<FacultyResponse>> addFaculty(@Valid @RequestBody CreateFacultyRequest req) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseData.success(facultyService.addFaculty(req)));
	}
	
	@GetMapping("/v1/admin-principal/get-all-faculty")
	@PreAuthorize("hasRole('ADMIN') or hasRole('PRINCIPAL')")
	@Operation(summary = "Get all Faculty", description = "Get all Faculty require ADMIN or PRINCIPAL")
	public ResponseEntity<ResponseData<List<FacultyResponse>>> getAllFaculty() {
		return ResponseEntity.ok(ResponseData.success(facultyService.getAllFaculty()));
	}
}