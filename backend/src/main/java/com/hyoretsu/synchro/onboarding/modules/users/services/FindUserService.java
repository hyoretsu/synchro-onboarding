package com.hyoretsu.synchro.onboarding.modules.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.FindUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.models.User;
import com.hyoretsu.synchro.onboarding.modules.users.repositories.UsersRepository;

@Service
public class FindUserService {
	@Autowired
	private UsersRepository usersRepository;

	@Nullable
	public User execute(FindUserDTO data) {
		User users = this.usersRepository.findByUsername(data);

		return users;
	}
}
