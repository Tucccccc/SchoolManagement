package com.example.diemdanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/public")
	public String hello() {
		return "Hello";
	}
}