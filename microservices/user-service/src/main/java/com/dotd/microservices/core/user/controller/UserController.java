package com.dotd.microservices.core.user.controller;

import com.dotd.api.core.user.UserDto;
import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserService;
import com.dotd.util.http.ServiceUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final ServiceUtil serviceUtil;
	private final UserService userService;

	@ApiOperation(value = "한 사람의 정보를 가져온다.", response = User.class)
	@ApiImplicitParam(name = "email", dataType = "String", value = "user email을 입력")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "사용자의 정보 반환", response = User.class),
			@ApiResponse(code = 204, message = "해당하는 id에 따른 사용자가 존재하지 않습니다. ", response = Void.class),
	})
	@GetMapping("/user/{email}")
	public UserDto getUser(@PathVariable String email){
		return userService.findOne(email);
		// 책에서는  serviceUtil 클래스에서 받은 서비스 주소k`	를 추가로 출력
	}

	@ApiOperation(value = "회원가입", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "유저 생성 완료", response = String.class),
	})
	@ApiImplicitParam(name = "action", dataType = "String", value = "")
	@PostMapping(path = "/user")
	public String joinUser(@RequestBody UserDto user) {
		return userService.join(user);
	}
}
