package com.hyoretsu.synchro.onboarding.modules.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.AuthenticateUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.dtos.FindUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.models.User;
import com.hyoretsu.synchro.onboarding.modules.users.providers.hash.model.IHashProvider;
import com.hyoretsu.synchro.onboarding.modules.users.providers.jwt.JwtProvider;
import com.hyoretsu.synchro.onboarding.modules.users.repositories.UsersRepository;

@Service
public class AuthenticateUserService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private IHashProvider hashProvider;

	@Autowired
	private JwtProvider jwtProvider;

	public String execute(AuthenticateUserDTO data) {
		User existingUser = this.usersRepository.findByUsername(new FindUserDTO(data.username));
		if (existingUser == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Essa conta não existe.");
		}

		Boolean passwordMatches = this.hashProvider.compareHash(data.password, existingUser.getPassword());
		if (!passwordMatches) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Senha incorreta.");
		}

		String jwt = this.jwtProvider.generateToken(data.username);

		return jwt;
	}
}
