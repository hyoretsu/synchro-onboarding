package com.hyoretsu.synchro.onboarding.modules.account;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.server.ResponseStatusException;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.repositories.AccountsRepository;
import com.hyoretsu.synchro.onboarding.modules.accounts.services.CreateAccountService;

public class CreateAccountServiceTest {
	@Mock
	private AccountsRepository accountsRepository;

	@InjectMocks
	private CreateAccountService createAccount;

	@Test
	public void shouldNotCreateADuplicateAccount() {
		CreateAccountDTO data = new CreateAccountDTO("testCompany", "testType");

		this.accountsRepository.save(new Account(data));

		assertThrows(ResponseStatusException.class, () -> {
			createAccount.execute(data);
		});
	}
}
