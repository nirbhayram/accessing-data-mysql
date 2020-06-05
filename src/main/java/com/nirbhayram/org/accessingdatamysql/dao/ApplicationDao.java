package com.nirbhayram.org.accessingdatamysql.dao;

import com.nirbhayram.org.accessingdatamysql.entity.Application;
import com.nirbhayram.org.accessingdatamysql.entity.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ApplicationDao implements IApplicationDao{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void addApplication(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public boolean applicationExists(String name, String owner) {
        List<Application> applicationsList = applicationRepository.findByNameAndOwner(name,owner);
        return applicationsList.size()>0;
    }
}
