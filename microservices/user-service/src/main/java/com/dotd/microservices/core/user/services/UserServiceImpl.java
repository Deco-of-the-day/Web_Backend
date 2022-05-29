package com.dotd.microservices.core.user.services;

import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserRepository;
import com.dotd.api.core.user.UserService;
import com.dotd.microservices.core.user.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    @Override
    @Transactional
    public Long join(User user){
        validateDuplictateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    /**
     * 이름이 중복되는 회원이 있는지 확인
     * @param user
     */
    private void validateDuplictateUser(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public User findOne(Long userId){
        return userRepository.findOne(userId);
    }
}
