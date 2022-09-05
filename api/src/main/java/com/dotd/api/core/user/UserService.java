package com.dotd.api.core.user;

import com.dotd.api.core.user.UserDto;
import com.dotd.api.core.user.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    String join(UserDto user);

    UserDto findOne(String email);
}
