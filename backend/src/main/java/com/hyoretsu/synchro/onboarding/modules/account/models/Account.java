package com.hyoretsu.synchro.onboarding.modules.account.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(indexes = {
		@Index(columnList = "company, type", unique = true)
})
@Getter
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 70, nullable = false)
	private String company;

	@Column(length = 30, nullable = false)
	private String type;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdAt;

	@LastModifiedDate
	@Column(nullable = false, updatable = false)
	private Date updatedAt;
}