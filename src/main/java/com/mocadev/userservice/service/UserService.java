package com.mocadev.userservice.service;

import com.mocadev.userservice.dto.UserDto;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-21
 **/
public interface UserService {

	UserDto createUser(UserDto userDto);

}
