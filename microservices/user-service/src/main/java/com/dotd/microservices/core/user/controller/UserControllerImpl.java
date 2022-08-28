package com.dotd.microservices.core.user.controller;

import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserService;
import com.dotd.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dotd.api.core.user.UserController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

	private final ServiceUtil serviceUtil;
	private final UserService userService;

	/*
	@Autowired
	public UserControllerImpl(ServiceUtil serviceUtil){
		this.serviceUtil = serviceUtil;
	}*/

	@Override
	public User getUser(Long userId){
		return userService.findOne(userId);
		// 책에서는  serviceUtil 클래스에서 받은 서비스 주소를 추가로 출력
	}

	@Override
	public Long joinUser(User user) {
		return null;
	}
}
