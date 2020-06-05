package com.nirbhayram.org.accessingdatamysql.service.application;

import com.nirbhayram.org.accessingdatamysql.dao.application.IApplicationDao;
import com.nirbhayram.org.accessingdatamysql.entity.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    private IApplicationDao applicationDao;

    @Override
    public synchronized boolean addApplication(Application application) {
        if (applicationDao.applicationExists(application.getName(),application.getOwner())){
            return false;
        }else{
            applicationDao.addApplication(application);
            return true;
        }
    }
}
