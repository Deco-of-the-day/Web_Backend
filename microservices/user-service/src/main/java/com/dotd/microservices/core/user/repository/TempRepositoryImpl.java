package com.dotd.microservices.core.user.repository;

import com.dotd.api.core.temp.Temp;
import com.dotd.api.core.temp.TempRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TempRepositoryImpl implements TempRepository {
    @PersistenceContext
    EntityManager em;
    @Override
    public Long save(Temp temp) {
        em.persist(temp);
        return temp.getId();
    }
    @Override
    public Temp find(Long id) {
        return em.find(Temp.class, id);
    }
}
