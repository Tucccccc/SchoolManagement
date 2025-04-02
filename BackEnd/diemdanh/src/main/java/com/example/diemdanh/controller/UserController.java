package com.example.diemdanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.service.UserManagementService;

@RestController
public class UserController {
	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/v1/admin/get-all-users")
	public ResponseEntity<UserDTO> getAllUsers() {
		return ResponseEntity.ok(userManagementService.getAllUsers());
	}
	
	@GetMapping("/v1/admin/get-user/{userId}")
	public ResponseEntity<UserDTO> getUserByID(@PathVariable Long userId) {
		return ResponseEntity.ok(userManagementService.getUserById(userId));
	}
	
	
	@PutMapping("/v1/admin/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userReq) {
		return ResponseEntity.ok(userManagementService.updateUser(userId, userReq));
	}
	
	@GetMapping("/v1/adminuser/get-profile")
	public ResponseEntity<UserDTO> getUserProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UserDTO response = userManagementService.getUserProfile(username);
		return ResponseEntity.status(response.getIntStatusCode()).body(response);
	}
	
	@DeleteMapping("/v1/admin/delete-user/{userId}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) {
		return ResponseEntity.ok(userManagementService.deleteUser(userId));
	}
}