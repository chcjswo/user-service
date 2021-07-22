package com.mocadev.userservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-22
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

	private String email;
	private String name;
	private String userId;
	private List<ResponseOrder> orders;

}
