package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ClassRequest;
import com.example.demo.dto.response.ClassResponse;
import com.example.demo.service.ClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Class Management", description = "APIs for managing Class")
public class ClassController {
	@Autowired
	private ClassService classService;
	
	@PostMapping("/v1/admin/add-class")
	@Operation(summary = "Add Class", description = "Save Class to Database")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "Error")
    })
	public ResponseEntity<ClassResponse> addClass(@RequestBody ClassRequest req) {
		ClassResponse classResult = classService.addClass(req);
		return ResponseEntity.ok(classResult);
	}
}