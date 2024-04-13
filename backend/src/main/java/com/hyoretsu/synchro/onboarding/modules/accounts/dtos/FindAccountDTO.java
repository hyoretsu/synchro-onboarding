package com.hyoretsu.synchro.onboarding.modules.accounts.dtos;

public class FindAccountDTO {
	public FindAccountDTO(CreateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	public String company;
	public String type;
}
