package com.hyoretsu.synchro.onboarding.modules.accounts.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;

@Repository
public interface AccountsRepository extends CrudRepository<Account, UUID> {
	@Query("SELECT a FROM Account a WHERE a.company = :#{#data.company} AND a.type = :#{#data.type}")
	@Nullable
	public Account find(FindAccountDTO data);

	@Query("SELECT a FROM Account a WHERE a.company ILIKE %:#{#data.company}% OR a.type ILIKE %:#{#data.type}%")
	@Nullable
	public Iterable<Account> search(FindAccountDTO data);
}
