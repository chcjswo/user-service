package com.mocadev.userservice.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-21
 **/
@Data
public class RequestUser {

	@NotNull(message = "이메일을 입력해주세요.")
	@Size(min = 2, message = "이메일은 2자 이상입니다.")
	private String email;
	@NotNull(message = "이름은 입력해주세요.")
	@Size(min = 2, message = "이름은 2자 이상입니다.")
	private String name;
	@NotNull(message = "패스워드를 입력해주세요.")
	@Size(min = 4, message = "패스워드는 4자 이상입니다.")
	private String pwd;

}
