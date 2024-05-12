package com.hyoretsu.synchro.onboarding.modules.accounts.dtos;

import java.util.UUID;

import org.springframework.lang.Nullable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateAccountDTO {
	public UpdateAccountDTO(CreateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	@Nullable
	public String company;

	public UUID id;

	@Nullable
	public String type;
}
