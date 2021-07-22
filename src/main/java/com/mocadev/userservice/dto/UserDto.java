package com.mocadev.userservice.dto;

import com.mocadev.userservice.vo.ResponseOrder;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-21
 **/
@Data
public class UserDto {

	private String email;
	private String name;
	private String pwd;
	private String userId;
	private Date createdAt;
	private String encryptedPwd;
	private List<ResponseOrder> orders;

}
