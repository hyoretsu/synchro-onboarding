package com.hyoretsu.synchro.onboarding.modules.accounts.infra.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.CreateAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	private CreateAccountService createAccount;

	public AccountsController(CreateAccountService createAccount) {
		this.createAccount = createAccount;
	}

	@GetMapping
	public Account getAccounts(CreateAccountDTO data) {
		Account account = this.createAccount.execute(data);

		return account;
	}
}
