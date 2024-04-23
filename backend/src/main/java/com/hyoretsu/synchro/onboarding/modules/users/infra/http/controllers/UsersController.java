package com.hyoretsu.synchro.onboarding.modules.users.infra.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyoretsu.synchro.onboarding.modules.users.dtos.AuthenticateUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.dtos.CreateUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.dtos.FindUserDTO;
import com.hyoretsu.synchro.onboarding.modules.users.models.User;
import com.hyoretsu.synchro.onboarding.modules.users.services.AuthenticateUserService;
import com.hyoretsu.synchro.onboarding.modules.users.services.CreateUserService;
import com.hyoretsu.synchro.onboarding.modules.users.services.FindUserService;
import com.hyoretsu.synchro.onboarding.modules.users.services.ListUsersService;
import com.hyoretsu.synchro.onboarding.modules.users.services.VerifyAuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private AuthenticateUserService authenticateUser;
	@Autowired
	private CreateUserService createUser;
	@Autowired
	private FindUserService findUser;
	@Autowired
	private ListUsersService listUsers;
	@Autowired
	private VerifyAuthService verifyAuth;

	public UsersController(CreateUserService createUser) {
		this.createUser = createUser;
	}

	@GetMapping
	@ResponseBody
	public List<User> getUsers() {
		List<User> user = this.listUsers.execute();

		return user;
	}

	@PostMapping
	@ResponseBody
	public User postUsers(CreateUserDTO data) {
		User user = this.createUser.execute(data);

		return user;
	}

	@GetMapping("/find")
	@ResponseBody
	@Nullable
	public User getUsersFind(@RequestParam String username) {
		User user = this.findUser.execute(new FindUserDTO(username));

		return user;
	}

	@GetMapping("/login")
	public void postUsersLogin(HttpServletRequest req, HttpServletResponse res) {
		// Coleta o JWT de verdade pelo cookie de auth
		String jwt = req.getCookies().toString();

		Boolean validJwt = this.verifyAuth.execute(jwt);

		res.setStatus(validJwt ? HttpStatus.OK.value() : HttpStatus.UNAUTHORIZED.value());
	}

	@PostMapping("/login")
	public void postUsersLogin(AuthenticateUserDTO data, HttpServletResponse response) {
		String jwt = this.authenticateUser.execute(data);

		ResponseCookie cookie = ResponseCookie.from("auth", jwt)
				.httpOnly(true)
				.secure(true)
				.path("/")
				.maxAge(24 * 60 * 60)
				.build();

		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		response.setStatus(HttpStatus.OK.value());
	}
}
