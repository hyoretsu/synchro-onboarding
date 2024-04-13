package com.hyoretsu.synchro.onboarding.modules.accounts.dtos;

public class CreateAccountDTO {
	public CreateAccountDTO(String company, String type) {
		this.company = company;
		this.type = type;
	}

	public final String company;
	public final String type;
}
