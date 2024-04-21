package com.hyoretsu.synchro.onboarding.modules.accounts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.repositories.AccountsRepository;

@Service
public class ListAccountsService {
	@Autowired
	private AccountsRepository accountsRepository;

	public List<Account> execute() {
		List<Account> accounts = this.accountsRepository.findAll();

		return accounts;
	}
}
