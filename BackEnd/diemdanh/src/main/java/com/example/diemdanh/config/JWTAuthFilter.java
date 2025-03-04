package com.example.diemdanh.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.diemdanh.service.JWTUtils;
import com.example.diemdanh.service.UserDetailsSV;

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

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String authHeader = request.getHeader("Authorization");
			String jwtToken;
			String userName;
			if (authHeader == null || authHeader.isBlank()) {
				filterChain.doFilter(request, response);
				return;
			}

			jwtToken = authHeader.substring(7);
			userName = jwtUtils.extractUsername(jwtToken);

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsSV.loadUserByUsername(userName);

				if (jwtUtils.isTokenValid(jwtToken, userDetails)) {
					SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					securityContext.setAuthentication(token);
					SecurityContextHolder.setContext(securityContext);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		filterChain.doFilter(request, response);
	}
}
