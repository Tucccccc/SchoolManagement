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

import com.example.diemdanh.dto.ReqResUser;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.service.UserManagementService;

@RestController
public class UserController {
	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/admin/get-all-users")
	public ResponseEntity<ReqResUser> getAllUsers() {
		return ResponseEntity.ok(userManagementService.getAllUsers());
	}
	
	@GetMapping("/admin/get-user/{userId}")
	public ResponseEntity<ReqResUser> getUserByID(@PathVariable Long userId) {
		return ResponseEntity.ok(userManagementService.getUserById(userId));
	}
	
	
	@PutMapping("/admin/update/{userId}")
	public ResponseEntity<ReqResUser> updateUser(@PathVariable Long userId, @RequestBody User userReq) {
		return ResponseEntity.ok(userManagementService.updateUser(userId, userReq));
	}
	
	@GetMapping("/adminuser/get-profile")
	public ResponseEntity<ReqResUser> getUserProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		ReqResUser response = userManagementService.getUserProfile(username);
		return ResponseEntity.status(response.getIntStatusCode()).body(response);
	}
	
	@DeleteMapping("/admin/delete-user/{userId}")
	public ResponseEntity<ReqResUser> deleteUser(@PathVariable Long userId) {
		return ResponseEntity.ok(userManagementService.deleteUser(userId));
	}
}