package com.hyoretsu.synchro.onboarding.modules.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyoretsu.synchro.onboarding.modules.users.providers.jwt.JwtProvider;

@Service
public class VerifyAuthService {
	@Autowired
	private JwtProvider jwtProvider;

	public Boolean execute(String jwt) {
		Boolean isValid = this.jwtProvider.validateToken(jwt);

		return isValid;
	}
}
