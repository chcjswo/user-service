package com.mocadev.userservice.vo;

import java.util.Date;
import lombok.Data;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-23
 **/
@Data
public class ResponseOrder {

	private String productId;
	private Integer qty;
	private Integer unitPrice;
	private Integer totalPrice;
	private Date createdAt;
	private String orderId;

}
