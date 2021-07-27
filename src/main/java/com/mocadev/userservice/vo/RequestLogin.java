package com.mocadev.userservice.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-28
 **/
@Data
public class RequestLogin {

	@NotNull(message = "Email cannot be null")
	@Size(min = 2, message = "2자리 이상")
	@Email
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, message = "8자리 이상")
	private String password;

}
