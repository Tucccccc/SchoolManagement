package com.example.diemdanh.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTUtils {
	private final SecretKey scrKey;
	private static final Long LONG_EXPIRATION_TIME = 8640000L;
	
	public JWTUtils() {
		String strSecret = "8432783248365872374683264732487326487326487ASVC87648732HCBVFSJK";
		byte[] btKey = strSecret.getBytes(StandardCharsets.UTF_8);
		this.scrKey = new SecretKeySpec(btKey, "HmacSHA256");
	}
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.subject(userDetails.getUsername())
				.claim("role", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + LONG_EXPIRATION_TIME))
				.signWith(scrKey)
				.compact();
	}
	
	public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails) {
		return Jwts.builder()
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + LONG_EXPIRATION_TIME))
				.signWith(scrKey)
				.compact();
	}
	
	public String extractUsername(String strToken) {
		return extractClaims(strToken, Claims::getSubject);
	}
	
	private <T> T extractClaims(String strToken, Function<Claims, T> claimsFunction) {
		return claimsFunction.apply(Jwts.parser().verifyWith(scrKey).build().parseSignedClaims(strToken).getPayload());
	}
	
	public boolean isTokenValid(String strToken, UserDetails userDetails) {
		final String strUsername = extractUsername(strToken);
		return MessageDigest.isEqual(strUsername.getBytes(), userDetails.getUsername().getBytes()) 
	       && !isTokenExpired(strToken);
	}

	private boolean isTokenExpired(String strToken) {
		return extractClaims(strToken, Claims::getExpiration).before(new Date());
	}
}