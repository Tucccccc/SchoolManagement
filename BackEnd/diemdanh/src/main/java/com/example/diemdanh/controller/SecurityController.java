package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.LogoutRequest;
import com.example.diemdanh.dto.RefreshTokenRequest;
import com.example.diemdanh.dto.TokenResponse;
import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.service.RefreshTokenService;
import com.example.diemdanh.service.UserManagementService;

@RestController
public class SecurityController {
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private RefreshTokenService refreshTokenService;

	@PostMapping("/v1/auth/register-student")
	public ResponseEntity<UserDTO> registerStudent(@RequestBody UserDTO reg) {
		return ResponseEntity.ok(userManagementService.registerStudent(reg));
	}
	
	@PostMapping("/v1/auth/register-teacher")
	public ResponseEntity<UserDTO> registerTeacher(@RequestBody UserDTO reg) {
		return ResponseEntity.ok(userManagementService.registerTeacher(reg));
	}

	@PostMapping("/v1/auth/login")
	public ResponseEntity<TokenResponse> login(@RequestBody UserDTO req) {
		return ResponseEntity.ok(userManagementService.login(req));
	}
	
	@PostMapping("/v1/auth/refresh")
	public ResponseEntity<TokenResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
		return ResponseEntity.ok(userManagementService.refreshToken(request.getRefreshToken()));
	}
	
	@PostMapping("/v1/auth/logout")
	public ResponseEntity<?> logout(@RequestBody LogoutRequest request) {
	    refreshTokenService.deleteByUser(userManagementService.getUserProfile(request.getUsername()).getUser());
	    return ResponseEntity.ok("Log out successful");
	}
}