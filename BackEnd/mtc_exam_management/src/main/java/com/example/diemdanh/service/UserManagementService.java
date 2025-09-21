package com.example.diemdanh.service;

import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.dto.request.LoginRequest;
import com.example.diemdanh.dto.response.LoginResponse;

public interface UserManagementService {
	UserDTO registerStudent(UserDTO registrationRequest);
	UserDTO registerTeacher(UserDTO registrationRequest);
	LoginResponse login(LoginRequest loginRequest);
	UserDTO getAllUsers();
	UserDTO getUserById(Long id);
	UserDTO deleteUser(Long id);
	UserDTO updateUser(Long id, UserDTO userUpdate);
	UserDTO getUserProfile(String strUsername);
	LoginResponse refreshToken(String refreshTokenStr);
}