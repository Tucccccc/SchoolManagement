package com.example.diemdanh.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.example.diemdanh.entity.ExceptionData;
import com.example.diemdanh.global.common.HttpStatusText;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Handle Access Denied for User's Role
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	// Default Spring Object Mapper
    @Autowired
    private ObjectMapper objectMapper;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        
		ExceptionData exceptionData = new ExceptionData(new Date(), 403, HttpStatusText.fromCode(403), "You do not have permission to access this resource.",
				request.getRequestURL().toString());
		
		response.getWriter().write(objectMapper.writeValueAsString(exceptionData));
	}
}