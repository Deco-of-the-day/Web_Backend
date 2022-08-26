package com.dotd.microservices.core.user;

import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserRepository;
import com.dotd.api.core.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired    UserService userService;
    @Autowired    UserRepository userRepository;
    @Autowired    EntityManager em;

    /**
     * 회원가입 테스트
     * 테스트 후, user table에 taxol이 떡하니 있으면 성공
     * @throws Exception
     */
    @Test
    @Rollback(false)
    public void signUp() throws Exception {
        //given
        User user = new User();
        user.setName("taxol");

        //when
        Long saveId = userService.join(user);

        //then
        assertEquals(user, userRepository.findOne(saveId));
    }

}
