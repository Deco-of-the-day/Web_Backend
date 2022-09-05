package com.dotd.microservices.core.user.services;

import com.dotd.api.core.user.UserDto;
import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserRepository;
import com.dotd.api.core.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
    public String join(UserDto userDto){
        validateDuplictateUser(userDto);
        User user = User.createUser(userDto.getEmail(), userDto.getNickname(), userDto.getPassword());

        userRepository.saveAndFlush(user);
        return user.getEmail();
    }

    /**
     * 이름이 중복되는 회원이 있는지 확인
     * @param user
     */
    private void validateDuplictateUser(UserDto user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public UserDto findOne(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user;
        UserDto userDto;
        if(userOptional.isPresent()){
            user = userOptional.get();
            userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setNickname(user.getNickname());
            userDto.setPassword(user.getPassword());
        } else {
            throw new EntityNotFoundException(
                    "Cant find any user under given email");
        }
        return userDto;
    }
}
