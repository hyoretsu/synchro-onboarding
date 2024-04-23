package com.hyoretsu.synchro.onboarding.modules.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyoretsu.synchro.onboarding.modules.users.models.User;
import com.hyoretsu.synchro.onboarding.modules.users.repositories.UsersRepository;

@Service
public class ListUsersService {
	@Autowired
	private UsersRepository usersRepository;

	public List<User> execute() {
		List<User> users = this.usersRepository.findAll();

		return users;
	}
}
