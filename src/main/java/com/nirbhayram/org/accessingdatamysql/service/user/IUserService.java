package com.nirbhayram.org.accessingdatamysql.service.user;

import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import java.util.List;

public interface IUserService {
    void addUser(User user);
    User getUserById(int id);
    List<User> getAllUser();
}
