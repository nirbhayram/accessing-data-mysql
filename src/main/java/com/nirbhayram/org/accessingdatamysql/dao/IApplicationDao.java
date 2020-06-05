package com.nirbhayram.org.accessingdatamysql.dao;

import com.nirbhayram.org.accessingdatamysql.entity.Application;

public interface IApplicationDao {

    void addApplication(Application application);
    boolean applicationExists(String name,String owner);

}
