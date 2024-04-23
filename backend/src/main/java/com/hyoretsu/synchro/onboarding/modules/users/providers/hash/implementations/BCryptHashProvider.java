package com.hyoretsu.synchro.onboarding.modules.users.providers.hash.implementations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hyoretsu.synchro.onboarding.modules.users.providers.hash.model.IHashProvider;

@Service
public class BCryptHashProvider implements IHashProvider {
	private final PasswordEncoder passwordEncoder;

	public BCryptHashProvider() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String generateHash(String payload) {
		return this.passwordEncoder.encode(payload);
	}

	@Override
	public Boolean compareHash(String payload, String hashed) {
		return this.passwordEncoder.matches(payload, hashed);
	}
}
