package com.hyoretsu.synchro.onboarding.modules.users.dtos;

public class CreateUserDTO {
	public CreateUserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public final String username;
	public final String password;
}
