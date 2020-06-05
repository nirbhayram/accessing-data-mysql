package com.nirbhayram.org.accessingdatamysql.dao.application;

import com.nirbhayram.org.accessingdatamysql.entity.application.Application;

public interface IApplicationDao {

    void addApplication(Application application);
    boolean applicationExists(String name,String owner);

}
