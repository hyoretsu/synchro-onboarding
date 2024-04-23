package com.hyoretsu.synchro.onboarding.modules.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.CreateUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.dtos.FindUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.models.User;
import com.hyoretsu.synchro.onboarding.modules.users.providers.hash.model.IHashProvider;
import com.hyoretsu.synchro.onboarding.modules.users.repositories.UsersRepository;

@Service
public class CreateUserService {
	@Autowired
	private IHashProvider hashProvider;

	@Autowired
	private UsersRepository usersRepository;

	public User execute(CreateUserDTO data) {
		User existingUser = this.usersRepository.findByUsername(new FindUserDTO(data.username));
		if (existingUser != null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta já existe.");
		}

		User user = new User(new CreateUserDTO(data.username, this.hashProvider.generateHash(data.password)));
		this.usersRepository.save(user);

		return user;
	}
}
