package com.hyoretsu.synchro.onboarding.modules.users.dtos;

public class AuthenticateUserDTO {
	public AuthenticateUserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public final String username;
	public final String password;
}
