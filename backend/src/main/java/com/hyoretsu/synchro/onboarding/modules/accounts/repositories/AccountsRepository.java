package com.hyoretsu.synchro.onboarding.modules.accounts.repositories;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;

public interface AccountsRepository {
	public Account create(CreateAccountDTO data);

	public Account find(FindAccountDTO data);
}
