package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.service.UserManagementService;

@RestController
public class SecurityController {
	@Autowired
	private UserManagementService userManagementService;

	@PostMapping("/v1/auth/register-student")
	public ResponseEntity<UserDTO> registerStudent(@RequestBody UserDTO reg) {
		return ResponseEntity.ok(userManagementService.registerStudent(reg));
	}
	
	@PostMapping("/v1/auth/register-teacher")
	public ResponseEntity<UserDTO> registerTeacher(@RequestBody UserDTO reg) {
		return ResponseEntity.ok(userManagementService.registerTeacher(reg));
	}

	@PostMapping("/v1/auth/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO req) {
		return ResponseEntity.ok(userManagementService.login(req));
	}
	
	@PostMapping("/v1/auth/refresh")
	public ResponseEntity<UserDTO> refreshToken(@RequestBody UserDTO req) {
		return ResponseEntity.ok(userManagementService.refreshToken(req));
	}
}