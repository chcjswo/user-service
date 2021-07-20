package com.mocadev.userservice.controller;

import com.mocadev.userservice.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-20
 **/
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

	private final Environment env;
	private final Greeting greeting;

	@GetMapping("/health-check")
	public String status() {
		return "It's Working in User Service";
	}

	@GetMapping("/welcome-env")
	public String welcomeEnv() {
		return env.getProperty("greeting.message");
	}

	@GetMapping("/welcome")
	public String welcome() {
		return greeting.getMessage();
	}

}
