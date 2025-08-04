package com.clinica.authservice.infrastructure.controller;

import com.clinica.authservice.infrastructure.config.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final JwtUtil jwtUtil;

	public AuthController(JwtUtil jwtUtil){
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password){
		if ("admin".equals(username)&&"1234".equals(password)){
			return jwtUtil.generateToken(username);
		}
		throw new RuntimeException("Credenciales invalidas");
	}
}
