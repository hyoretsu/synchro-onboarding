package com.hyoretsu.synchro.onboarding.modules.accounts.dtos;

import jakarta.annotation.Nullable;

public class FindAccountDTO {
	public FindAccountDTO(String company, String type) {
		this.company = company;
		this.type = type;
	}

	public FindAccountDTO(CreateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	public FindAccountDTO(UpdateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	public @Nullable String company;
	public @Nullable String type;
}
