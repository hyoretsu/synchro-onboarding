package com.hyoretsu.synchro.onboarding.modules.accounts.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
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

	public Iterable<Account> listAccounts(@Nullable FindAccountDTO data) {
		Iterable<Account> accounts;

		if (data != null) {
			accounts = this.accountsRepository.search(data);
		} else {
			accounts = this.accountsRepository.findAll();
		}

		return accounts;
	}

	public void updateAccount(UpdateAccountDTO data) {
		Optional<Account> existingAccount = this.accountsRepository.findById(data.id);
		System.out.println(data.company);
		System.out.println(data.type);
		System.out.println(data.id);
		if (existingAccount.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta não existe.");
		}

		Account updatedAccount = existingAccount.get();
		updatedAccount.update(data);

		this.accountsRepository.save(updatedAccount);
	}
}
