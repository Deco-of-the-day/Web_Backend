package com.dotd.microservices.core.user.repository;

import com.dotd.api.core.user.User;
import com.dotd.api.core.user.UserRepository;
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
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user){
        em.persist(user);
    }

    @Override
    public User findOne(Long id){
        return em.find(User.class, id);
    }

    /**
     * 유저의 이름으로 유저의 정보들을 가져온다.
     *
     * @param name
     * @return
     */
    @Override
    public List<User> findByName(String name){
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
}

