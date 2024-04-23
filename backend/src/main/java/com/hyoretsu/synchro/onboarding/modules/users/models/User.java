package com.hyoretsu.synchro.onboarding.modules.users.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.CreateUserDTO;

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
public class User {
	public User(CreateUserDTO data) {
		this.username = data.username;
		this.password = data.password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 30, nullable = false)
	private String username;

	@Column(length = 60, nullable = false)
	private String password;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = false)
	private Date createdAt;

	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = false)
	private Date updatedAt;
}
