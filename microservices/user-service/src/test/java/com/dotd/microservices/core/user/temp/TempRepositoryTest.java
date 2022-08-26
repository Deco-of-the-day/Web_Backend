package com.dotd.microservices.core.user.temp;

import com.dotd.api.core.temp.Temp;
import com.dotd.api.core.temp.TempRepository;
import com.dotd.microservices.core.user.repository.TempRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TempRepositoryTest {

    @Autowired
    TempRepository tempRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void save() {
        Temp member = new Temp();
        member.setName("memberB");

        //when
        Long saveId = tempRepository.save(member);        // 생성한 member를 db에 넣는다.
        Temp findMember = tempRepository.find(saveId);  // 앞선 리턴 id를 조회하여 db에서 member를 얻는다.

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());    // 처음에 생성한 member와 db의 member가 같은지 확인
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}