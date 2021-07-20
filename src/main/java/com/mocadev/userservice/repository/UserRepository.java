package com.mocadev.userservice.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2021-07-21
 **/
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
