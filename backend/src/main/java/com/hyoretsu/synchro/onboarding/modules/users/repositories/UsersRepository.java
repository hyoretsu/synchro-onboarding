package com.hyoretsu.synchro.onboarding.modules.users.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.FindUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {
	@Query("SELECT a FROM User a WHERE a.username = :#{#data.username}")
	@Nullable
	public User findByUsername(FindUserDTO data);
}
