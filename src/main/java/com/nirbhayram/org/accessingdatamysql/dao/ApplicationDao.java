package com.nirbhayram.org.accessingdatamysql.dao;

import com.nirbhayram.org.accessingdatamysql.entity.Application;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ApplicationDao implements IApplicationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application application) {
        entityManager.persist(application);
    }

    @Override
    public boolean applicationExists(String name, String owner) {
        String jql = "from Application as a WHERE a.name = ? and a.owner = ?";
        int result_count = entityManager.createQuery(jql).setParameter(0,name).setParameter(1   ,owner).getResultList().size();
        return result_count>0;
    }
}
