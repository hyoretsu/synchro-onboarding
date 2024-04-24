package com.hyoretsu.synchro.onboarding.modules.accounts.dtos;

import org.springframework.lang.Nullable;

public class UpdateAccountDTO {
	public UpdateAccountDTO(CreateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	@Nullable
	public String company;

	@Nullable
	public String type;
}
