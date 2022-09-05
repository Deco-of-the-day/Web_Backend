package com.dotd.api.core.user;

import com.dotd.api.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 2022.05.29
 * 유저 회원가입, 조회
 *
 * @author taxol
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
