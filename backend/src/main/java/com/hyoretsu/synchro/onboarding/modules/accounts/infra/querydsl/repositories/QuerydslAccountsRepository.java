package com.hyoretsu.synchro.onboarding.modules.accounts.infra.querydsl.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.FindAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.Account;
import com.hyoretsu.synchro.onboarding.modules.accounts.models.QAccount;
import com.hyoretsu.synchro.onboarding.modules.accounts.repositories.AccountsRepository;
import com.hyoretsu.synchro.onboarding.shared.infra.querydsl.BaseRepository;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.SQLInsertClause;

@Repository
@Qualifier("AccountsRepository")
public class QuerydslAccountsRepository extends BaseRepository<Account, QAccount> implements AccountsRepository {
	public QuerydslAccountsRepository(SQLQueryFactory queryFactory) {
		super(QAccount.account, queryFactory);
	}

	public Account create(CreateAccountDTO data) {
		SQLInsertClause query = this.insertQuery();

		Account account = new Account(data);

		query.populate(account).executeWithKeys();

		return account;
	};

	public Account find(FindAccountDTO data) {
		SQLQuery<Account> query = this.selectQuery();

		Account account = query.where(this.entity.company.eq(data.company), this.entity.type.eq(data.type)).fetchOne();

		return account;
	};
}
