package com.example.diemdanh.service;

import java.util.Optional;

import com.example.diemdanh.entity.RefreshToken;
import com.example.diemdanh.entity.User;

public interface RefreshTokenService {
	// * Find Refresh Token
	// Input: String token
	// Output: Optional refreshToken
	// Giang Ngo Truong 29/04/2025
	Optional<RefreshToken> findByToken(String token);
	
	// * Delete Refresh Token by User
	// Input: User user
	// Output: 
	// Giang Ngo Truong 29/04/2025
	void deleteByUser(User user);
	
	// * Create Refresh Token
	// Input: User user
	// Output: RefreshToken refreshToken
	// Giang Ngo Truong 29/04/2025
	RefreshToken createRefreshToken(User user);
	
	boolean isTokenExpired(RefreshToken token);
}