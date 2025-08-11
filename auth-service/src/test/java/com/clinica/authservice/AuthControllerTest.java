package com.clinica.authservice;


import com.clinica.authservice.infrastructure.config.JwtUtil;
import com.clinica.authservice.infrastructure.controller.AuthController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthControllerTest {

	@Test
	void loginDebeRetornarTokenCuandoCredencialesSonCorrectas(){
		JwtUtil jwtUtil = new JwtUtil();
		AuthController controller = new AuthController(jwtUtil);

		String token = controller.login("admin","1234");

		assertNotNull(token);
		assertTrue(token.length() > 10);

	}
}
