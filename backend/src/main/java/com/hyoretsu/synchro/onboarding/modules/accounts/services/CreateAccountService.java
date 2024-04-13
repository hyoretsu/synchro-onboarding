package com.hyoretsu.synchro.onboarding.modules.accounts.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.repositories.AccountsRepository;

@Service
public class CreateAccountService {
	private final AccountsRepository accountsRepository;

	public CreateAccountService(
			@Qualifier("AccountsRepository") AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public Account execute(CreateAccountDTO data) {
		Account existingAccount = this.accountsRepository.find(new FindAccountDTO(data));
		if (existingAccount != null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta já existe.");
		}

		Account account = this.accountsRepository.create(data);

		return account;
	}
}
