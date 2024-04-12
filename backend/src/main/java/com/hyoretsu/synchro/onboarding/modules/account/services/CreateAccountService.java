package com.hyoretsu.synchro.onboarding.modules.account.services;

import com.hyoretsu.synchro.onboarding.modules.account.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.account.models.Account;
import com.hyoretsu.synchro.onboarding.modules.account.repositories.AccountsRepository;

public class CreateAccountService {
	private final AccountsRepository accountsRepository;

	public CreateAccountService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public Account execute(CreateAccountDTO data) {
		Account existingAccount = this.accountsRepository.find(data);
		if (existingAccount != null) {
			// throw new HttpException("Essa conta já existe.", HttpStatus.CONFLICT);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
							trackDTO.getId().toString()))
					.body(result);
		}

		Account account = this.accountsRepository.create();

		return account;
	}
}
