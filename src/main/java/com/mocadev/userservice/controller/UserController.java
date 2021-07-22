package com.mocadev.userservice.controller;

import com.mocadev.userservice.dto.UserDto;
import com.mocadev.userservice.service.UserService;
import com.mocadev.userservice.vo.Greeting;
import com.mocadev.userservice.vo.RequestUser;
import com.mocadev.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private final UserService userService;

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

	@PostMapping("/users")
	public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(requestUser, UserDto.class);
		userService.createUser(userDto);
		ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
	}

}
