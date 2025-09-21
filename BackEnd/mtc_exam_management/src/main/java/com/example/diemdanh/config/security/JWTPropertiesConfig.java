package com.example.diemdanh.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.jwt")
public class JWTPropertiesConfig {
    private String secret;
    private long expiration;
    
	public JWTPropertiesConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JWTPropertiesConfig(String secret, long expiration) {
		super();
		this.secret = secret;
		this.expiration = expiration;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public long getExpiration() {
		return expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}
}