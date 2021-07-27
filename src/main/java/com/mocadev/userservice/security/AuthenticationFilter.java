package com.mocadev.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocadev.userservice.vo.RequestLogin;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-28
 **/
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(
		HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			RequestLogin login = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
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
	}

}
