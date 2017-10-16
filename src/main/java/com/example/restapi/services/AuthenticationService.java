package com.example.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.restapi.exceptions.InvalidCredentialsException;
import com.example.restapi.generators.TokenGenerator;
import com.example.restapi.models.Token;
import com.example.restapi.models.User;
import com.example.restapi.params.SignInParam;
import com.example.restapi.repositories.TokenRepository;
import com.example.restapi.repositories.UsersRepository;

@Component
public class AuthenticationService {

	private UsersRepository usersRepository;
	private TokenRepository tokenRepository;
	@Value("${c.authentication.token_length}")
	private int tokenLength;

	@Autowired
	public AuthenticationService(UsersRepository usersRepository, TokenRepository tokenRepository) {
		this.usersRepository = usersRepository;
		this.tokenRepository = tokenRepository;
	}

	public Token signIn(SignInParam param) {
		int tokenLength = this.tokenLength;
		User user = usersRepository.findByEmailAndPassword(param.getEmail(), param.getPassword());
		if (user == null)
			throw new InvalidCredentialsException();
		Token token = new Token();
		token.setUser(user);
		token.setKey(TokenGenerator.getToken(tokenLength));
		return tokenRepository.save(token);
	}

}
