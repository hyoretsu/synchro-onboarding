package com.hyoretsu.synchro.onboarding.modules.accounts.infra.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.CreateAccountService;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.ListAccountsService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	@Autowired
	private CreateAccountService createAccount;
	@Autowired
	private ListAccountsService listAccounts;

	public AccountsController(CreateAccountService createAccount) {
		this.createAccount = createAccount;
	}

	@GetMapping
	public List<Account> getAccounts() {
		List<Account> account = this.listAccounts.execute();

		return account;
	}

	@PostMapping
	public Account postAccounts(CreateAccountDTO data) {
		Account account = this.createAccount.execute(data);

		return account;
	}
}
