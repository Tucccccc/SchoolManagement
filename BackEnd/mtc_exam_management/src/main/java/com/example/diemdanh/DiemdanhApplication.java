package com.example.diemdanh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.diemdanh.config.security.JWTPropertiesConfig;

@SpringBootApplication
@EnableConfigurationProperties(JWTPropertiesConfig.class)
public class DiemdanhApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiemdanhApplication.class, args);
	}
}