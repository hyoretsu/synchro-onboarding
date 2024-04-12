package com.hyoretsu.synchro.onboarding.modules.account.repositories;

import com.hyoretsu.synchro.onboarding.modules.account.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.account.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.account.models.Account;

public abstract class AccountsRepository {
	public abstract Account create(CreateAccountDTO data);

	public abstract Account find(FindAccountDTO data);
}
