package com.hyoretsu.synchro.onboarding.modules.accounts.models;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.CreateAccountDTO;
import com.hyoretsu.synchro.onboarding.modules.accounts.dtos.UpdateAccountDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(indexes = {
		@Index(columnList = "company, type", unique = true)
})
@Getter
@EqualsAndHashCode
public class Account {
	// O meu AccountsRepository.find() com @Nullable precisa disso aparentemente
	public Account() {
	}

	public Account(CreateAccountDTO data) {
		this.company = data.company;
		this.type = data.type;
	}

	public void update(UpdateAccountDTO data) {
		if (data.company != null) {
			this.company = data.company;
		}
		if (data.type != null) {
			this.type = data.type;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 70, nullable = false)
	private String company;

	@Column(length = 30, nullable = false)
	private String type;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date updatedAt;
}
