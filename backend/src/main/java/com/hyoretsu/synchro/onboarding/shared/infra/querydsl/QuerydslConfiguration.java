package com.hyoretsu.synchro.onboarding.shared.infra.querydsl;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class QuerydslConfiguration {
	@Bean
	public com.querydsl.sql.Configuration querydslConfiguration() {
		SQLTemplates templates = new PostgreSQLTemplates();
		Configuration configuration = new Configuration(templates);
		configuration.setExceptionTranslator(new SpringExceptionTranslator());
		return configuration;
	}

	@Bean
	public SQLQueryFactory sqlQueryFactory(DataSource dataSource, com.querydsl.sql.Configuration configuration) {
		return new SQLQueryFactory(configuration, new SpringConnectionProvider(dataSource));
	}
}
