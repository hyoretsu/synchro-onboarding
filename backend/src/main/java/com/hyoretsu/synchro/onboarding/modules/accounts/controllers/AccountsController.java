package com.hyoretsu.synchro.onboarding.modules.accounts.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.UpdateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.AccountsService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	@Autowired
	private AccountsService accountsService;

	@GetMapping("")
	@ResponseBody
	public Iterable<Account> getAccounts(@Nullable @RequestParam("company") String company,
			@Nullable @RequestParam("type") String type) {
		// Aberração, se eu tivesse tempo pra brincar que nem era antigamente ia ver
		// como evitar isso
		Iterable<Account> account = this.accountsService
				.listAccounts(company == null && type == null ? null : new FindAccountDTO(company, type));

		return account;
	}

	@PostMapping("")
	@ResponseBody
	public Account postAccounts(@RequestBody CreateAccountDTO data) {
		Account account = this.accountsService.createAccount(data);

		return account;
	}

	@PatchMapping("")
	@ResponseBody
	public void patchAccounts(@RequestBody UpdateAccountDTO data) {
		this.accountsService.updateAccount(data);
	}

	@DeleteMapping("")
	@ResponseBody
	public void deleteAccounts(@RequestParam("id") UUID accountId) {
		this.accountsService.deleteAccount(accountId);
	}
}
