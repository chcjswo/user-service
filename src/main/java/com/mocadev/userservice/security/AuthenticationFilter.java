package com.mocadev.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocadev.userservice.dto.UserDto;
import com.mocadev.userservice.service.UserService;
import com.mocadev.userservice.vo.RequestLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-28
 **/
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final UserService userService;
	private final Environment env;

	public AuthenticationFilter(AuthenticationManager authenticationManager,
								UserService userService,
								Environment env) {
		super.setAuthenticationManager(authenticationManager);
		this.userService = userService;
		this.env = env;
	}

	@Override
	public Authentication attemptAuthentication(
		HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			RequestLogin login = new ObjectMapper().readValue(request.getInputStream(),
				RequestLogin.class);
			return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),
						login.getPassword(),
						new ArrayList<>()
					)
				);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult)
		throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDetails = userService.getUserDetailByEmail(username);

		String token = Jwts.builder()
			.setSubject(userDetails.getUserId())
			.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(
				Objects.requireNonNull(env.getProperty("token.expiration_time")))))
			.signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
			.compact();

		response.addHeader("token", token);
		response.addHeader("userId", userDetails.getUserId());
	}

}
