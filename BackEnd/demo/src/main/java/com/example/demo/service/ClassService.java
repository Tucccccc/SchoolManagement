package com.example.demo.service;

import com.example.demo.dto.request.ClassRequest;
import com.example.demo.dto.response.ClassResponse;

public interface ClassService {
	// * Add Class
	// Input: ClassDTO addClass
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	ClassResponse addClass(ClassRequest classRequest);
}
