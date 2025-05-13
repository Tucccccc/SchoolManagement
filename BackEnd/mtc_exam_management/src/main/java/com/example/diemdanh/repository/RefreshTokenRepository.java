package com.example.diemdanh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diemdanh.entity.RefreshToken;
import com.example.diemdanh.entity.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
    Optional<RefreshToken> findByUser(User user);
}