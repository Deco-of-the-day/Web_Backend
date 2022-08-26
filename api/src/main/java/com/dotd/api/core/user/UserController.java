package com.dotd.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserController {

	// example in book
	// 나중에 수정 필요
	@GetMapping(
		value = "/user/{userId}",
		produces = "application/json")
	User getUser(@PathVariable Long userId);

	@PostMapping(
			value = "/user",
			produces = "application/json")
	Long joinUser(User user);
}
