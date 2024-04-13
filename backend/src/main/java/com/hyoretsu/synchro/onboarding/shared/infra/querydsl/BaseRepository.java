package com.hyoretsu.synchro.onboarding.shared.infra.querydsl;

import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.SQLInsertClause;

public class BaseRepository<Entity, QEntity extends RelationalPathBase<Entity>> {
	protected final QEntity entity;
	private final SQLQueryFactory queryFactory;

	public BaseRepository(QEntity entity, SQLQueryFactory queryFactory) {
		this.entity = entity;
		this.queryFactory = queryFactory;
	}

	protected SQLInsertClause insertQuery() {
		SQLInsertClause query = this.queryFactory.insert(this.entity);

		return query;
	}

	protected SQLQuery<Entity> selectQuery() {
		SQLQuery<Entity> query = this.queryFactory.selectFrom(this.entity);

		return query;
	}
}
