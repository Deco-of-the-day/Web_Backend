package com.dotd.microservices.core.user.repository;

import com.dotd.api.core.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 유저 회원가입, 조회
 *
 * @author taxol
 * @version 1.0
 */
//@Repository
public class UserRepositoryImpl_del  {

//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public void save(User user){
//        em.persist(user);
//    }
//
//    @Override
//    public User findOne(String email){
//        return em.find(User.class, email);
//    }
//
//    /**
//     * 유저의 이름으로 유저의 정보들을 가져온다.
//     *
//     * @param nickname
//     * @return
//     */
//    @Override
//    public List<User> findByName(String nickname){
//        return em.createQuery("select u from User u where u.nickname = :nickname", User.class)
//                .setParameter("nickname", nickname)
//                .getResultList();
//    }
//
}

