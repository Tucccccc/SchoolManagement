package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.ReqResUser;
import com.example.diemdanh.service.UserManagementService;

@RestController
public class SecurityController {
	@Autowired
	private UserManagementService userManagementService;

	@PostMapping("/auth/register")
	public ResponseEntity<ReqResUser> register(@RequestBody ReqResUser reg) {
		return ResponseEntity.ok(userManagementService.register(reg));
	}

	@PostMapping("/auth/login")
	public ResponseEntity<ReqResUser> login(@RequestBody ReqResUser req) {
		return ResponseEntity.ok(userManagementService.login(req));
	}
	
	@PostMapping("/auth/refresh")
	public ResponseEntity<ReqResUser> refreshToken(@RequestBody ReqResUser req) {
		return ResponseEntity.ok(userManagementService.refreshToken(req));
	}
}