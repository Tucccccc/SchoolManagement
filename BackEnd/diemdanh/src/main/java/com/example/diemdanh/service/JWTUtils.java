package com.example.diemdanh.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTUtils {
	private final SecretKey scrKey;
	private static final Long LONG_EXPIRATION_TIME = 8640000L;
	
	public JWTUtils() {
		String strSecret = "843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3";
		byte[] btKey = java.util.Base64.getDecoder().decode(strSecret.getBytes(StandardCharsets.UTF_8));
		this.scrKey = new SecretKeySpec(btKey, "HmacSHA256");
	}
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + LONG_EXPIRATION_TIME))
				.signWith(scrKey)
				.compact();
	}
	
	public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails) {
		return Jwts.builder()
				.claims(claims)
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
		return (strUsername.equals(userDetails.getUsername()) && !isTokenExpired(strToken));
	}

	private boolean isTokenExpired(String strToken) {
		return extractClaims(strToken, Claims::getExpiration).before(new Date());
	}
}