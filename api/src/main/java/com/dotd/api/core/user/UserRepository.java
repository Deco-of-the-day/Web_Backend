package com.dotd.api.core.user;

import com.dotd.api.core.user.User;

import java.util.List;

/**
 * 2022.05.29
 * 유저 회원가입, 조회
 *
 * @author taxol
 * @version 1.0
 */
public interface UserRepository {
    void save(User user);

    User findOne(Long id);

    List<User> findByName(String name);
}
