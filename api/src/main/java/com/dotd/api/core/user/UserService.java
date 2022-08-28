package com.dotd.api.core.user;

import com.dotd.api.core.user.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    Long join(User user);

    User findOne(Long userId);
}
