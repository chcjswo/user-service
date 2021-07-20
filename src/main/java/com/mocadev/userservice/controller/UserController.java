package com.mocadev.userservice.controller;

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

	@GetMapping("/health-check")
	public String status() {
		return "It's Working in User Service";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return env.getProperty("greeting.message");
	}

}
