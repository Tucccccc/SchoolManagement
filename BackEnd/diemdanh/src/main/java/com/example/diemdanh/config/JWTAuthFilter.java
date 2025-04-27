package com.example.diemdanh.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.diemdanh.entity.ExceptionData;
import com.example.diemdanh.global.common.HttpStatusText;
import com.example.diemdanh.service.implement.UserDetailsSV;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private UserDetailsSV userDetailsSV;

	// Default Spring Object Mapper
	@Autowired
	private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                authenticateRequest(token);
            }

            // Tiếp tục filter chain nếu không có lỗi
            filterChain.doFilter(request, response);

        } catch (JwtException ex) {
            handleJwtException(response, "Invalid JWT: " + ex.getMessage(), HttpServletResponse.SC_UNAUTHORIZED, request.getRequestURI());
        } catch (Exception ex) {
            handleJwtException(response, "Unexpected error: " + ex.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR, request.getRequestURI());
        }
    }
    
    private void authenticateRequest(String token) {
        String username = jwtUtils.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsSV.loadUserByUsername(username);

            if (jwtUtils.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
    }
    
    private void handleJwtException(HttpServletResponse response, String message, int status, String path) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");

		ExceptionData exceptionData = new ExceptionData(new Date(), status, HttpStatusText.fromCode(status), message,
				path);
        response.getWriter().write(objectMapper.writeValueAsString(exceptionData));
    }
}