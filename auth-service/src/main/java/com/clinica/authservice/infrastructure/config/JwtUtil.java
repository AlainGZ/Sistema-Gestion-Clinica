package com.clinica.authservice.infrastructure.config;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Component
public class JwtUtil {
	private final String SECRET = "secretKey123";
	private final long EXPIRATION = 1000 * 60 * 60;

	public String generateToken(String username){
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
	}
}
