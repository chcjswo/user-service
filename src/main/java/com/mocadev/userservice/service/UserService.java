package com.mocadev.userservice.service;

import com.mocadev.userservice.dto.UserDto;
import com.mocadev.userservice.repository.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-21
 **/
public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userDto);

	UserDto getUserByUserId(String userId);

	Iterable<UserEntity> getUserByAll();

}
