package com.hyoretsu.synchro.onboarding.modules.users.providers.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
	// Substituir por variáveis de ambiente
	public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";

	// @Value("${jwt.cookieExpiry}")
	private int cookieExpiry = 24;

	private SecretKey getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public Boolean validateToken(String token) {
		try {
			Claims claims = Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();

			return claims.getExpiration().after(new Date());
		} catch (JwtException e) {
			return false;
		}
	}

	public String generateToken(String username) {
		Date now = new Date();

		String jwt = Jwts.builder()
				.subject(username)
				.expiration(new Date(now.getTime() + cookieExpiry * 1000L))
				.issuedAt(new Date(System.currentTimeMillis()))
				.signWith(getSignKey())
				.compact();

		return jwt;
	}
}
