package com.hyoretsu.synchro.onboarding.modules.accounts.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.UpdateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.AccountsService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	@Autowired
	private AccountsService accountsService;

	@GetMapping("/")
	@ResponseBody
	public Iterable<Account> getAccounts() {
		Iterable<Account> account = this.accountsService.listAccounts();

		return account;
	}

	@PostMapping("/")
	@ResponseBody
	public Account postAccounts(CreateAccountDTO data) {
		Account account = this.accountsService.createAccount(data);

		return account;
	}

	@PatchMapping("/")
	@ResponseBody
	public void patchAccounts(UpdateAccountDTO data) {
		this.accountsService.updateAccount(data);
	}

	@DeleteMapping("/")
	@ResponseBody
	public void deleteAccounts(@RequestParam("id") UUID accountId) {
		this.accountsService.deleteAccount(accountId);
	}
}
