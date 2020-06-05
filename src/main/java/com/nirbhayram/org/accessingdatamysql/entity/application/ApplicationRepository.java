package com.nirbhayram.org.accessingdatamysql.entity.application;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    List<Application> findByNameAndOwner(String name,String owner);
}
