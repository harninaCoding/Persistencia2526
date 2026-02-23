package com.adorno.services;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adorno.configuration.security.jwt.JWTUtils;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AccessService {
	private final JWTUtils jwtUtils;

	public AccessService(JWTUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}

	public ResponseEntity<?> refreshToken(HttpServletRequest request) {
		String name = "RefreshToken";
		String refreshToken = request.getHeader(name);
		if (jwtUtils.isTokenValid(refreshToken)) {
			String username = jwtUtils.getUSerNameFromToken(refreshToken);
			// Generamos solo un nuevo Access Token (la llave diaria)
			String newAccessToken = jwtUtils.generateAccessToken(username);
			 return ResponseEntity.ok(Map.of(
			            "accesstoken", newAccessToken,
			            "message", "Token renovado con éxito"
			        ));
		}
		// Si el refresh también caducó... entonces sí: 401 y al Login de cabeza
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sesión expirada totalmente");
	}
}
