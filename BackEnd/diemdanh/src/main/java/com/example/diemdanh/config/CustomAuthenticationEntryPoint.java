package com.example.diemdanh.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.diemdanh.entity.ExceptionData;
import com.example.diemdanh.global.common.HttpStatusText;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	// Default Spring Object Mapper
    @Autowired
    private ObjectMapper objectMapper;
    
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

		ExceptionData exceptionData = new ExceptionData(new Date(), 401, HttpStatusText.fromCode(401), "You are not authenticated.",
				request.getRequestURL().toString());
		
        response.getWriter().write(objectMapper.writeValueAsString(exceptionData));
	}
}