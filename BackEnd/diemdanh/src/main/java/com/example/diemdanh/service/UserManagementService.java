package com.example.diemdanh.service;

import com.example.diemdanh.dto.TokenResponse;
import com.example.diemdanh.dto.UserDTO;

public interface UserManagementService {
	UserDTO registerStudent(UserDTO registrationRequest);
	UserDTO registerTeacher(UserDTO registrationRequest);
	TokenResponse login(UserDTO loginRequest);
	UserDTO getAllUsers();
	UserDTO getUserById(Long id);
	UserDTO deleteUser(Long id);
	UserDTO updateUser(Long id, UserDTO userUpdate);
	UserDTO getUserProfile(String strUsername);
	TokenResponse refreshToken(String refreshTokenStr);
}