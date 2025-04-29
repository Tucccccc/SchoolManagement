package com.example.diemdanh.service.implement;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diemdanh.entity.RefreshToken;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.repository.RefreshTokenRepository;
import com.example.diemdanh.service.RefreshTokenService;

import jakarta.transaction.Transactional;

@Service
public class RefreshTokenServiceImplement implements RefreshTokenService{
	private static final long REFRESH_TOKEN_VALIDITY_SECONDS = 7 * 24 * 60 * 60;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Override
	@Transactional
	public void deleteByUser(User user) {
		refreshTokenRepository.deleteByUser(user);
	}

	@Override
	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}

	@Override
	public RefreshToken createRefreshToken(User user) {
		Optional<RefreshToken> existingToken = refreshTokenRepository.findByUser(user);
		RefreshToken refreshToken = existingToken.orElse(new RefreshToken());
        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusSeconds(REFRESH_TOKEN_VALIDITY_SECONDS));
        return refreshTokenRepository.save(refreshToken);
	}
	
    public boolean isTokenExpired(RefreshToken token) {
        return token.getExpiryDate().isBefore(Instant.now());
    }
}