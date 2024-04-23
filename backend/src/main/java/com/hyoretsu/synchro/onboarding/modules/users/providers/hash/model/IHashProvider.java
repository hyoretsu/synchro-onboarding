package com.hyoretsu.synchro.onboarding.modules.users.providers.hash.model;

public interface IHashProvider {
	public Boolean compareHash(String payload, String hashed);

	public String generateHash(String payload);
}
