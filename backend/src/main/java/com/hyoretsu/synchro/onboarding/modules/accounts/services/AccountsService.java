package com.hyoretsu.synchro.onboarding.modules.accounts.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.UpdateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.repositories.AccountsRepository;

@Service
public class AccountsService {
	@Autowired
	private AccountsRepository accountsRepository;

	public Account createAccount(CreateAccountDTO data) {
		Account existingAccount = this.accountsRepository.find(new FindAccountDTO(data));
		if (existingAccount != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Essa conta já existe.");
		}

		Account account = new Account(data);
		this.accountsRepository.save(account);

		return account;
	}

	public void deleteAccount(UUID accountId) {
		Optional<Account> existingAccount = this.accountsRepository.findById(accountId);
		if (existingAccount.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta não existe.");
		}

		this.accountsRepository.deleteById(accountId);
	}

	public Iterable<Account> listAccounts() {
		Iterable<Account> accounts = this.accountsRepository.findAll();

		return accounts;
	}

	public void updateAccount(UpdateAccountDTO data) {
		Account existingAccount = this.accountsRepository.find(new FindAccountDTO(data));
		if (existingAccount == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta não existe.");
		}

		existingAccount.update(data);

		this.accountsRepository.save(existingAccount);
	}
}
