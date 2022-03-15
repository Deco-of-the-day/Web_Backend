package com.dotd.microservices.core.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserService;
import com.dotd.util.http.ServiceUtil;

@RestController
public class UserServiceImpl implements UserService {

//	private final ServiceUtil serviceUtil;
//
//	@Autowired
//	public UserServiceImpl(ServiceUtil serviceUtil){
//		this.serviceUtil = serviceUtil;
//	}
//
//	@Override
//	public User getUser(int userId){
//		return new User(userId, "name-" + userId);
//		// 책에서는  serviceUtil 클래스에서 받은 서비스 주소를 추가로 출력
//	}
}
