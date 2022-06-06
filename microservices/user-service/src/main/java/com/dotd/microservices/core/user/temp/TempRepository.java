package com.dotd.microservices.core.user.temp;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TempRepository {
    @PersistenceContext
    EntityManager em;
    public Long save(Temp temp) {
        em.persist(temp);
        return temp.getId();
    }
    public Temp find(Long id) {
        return em.find(Temp.class, id);
    }
}
